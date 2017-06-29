package com.venyou.poc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PocApplication {

    public static Gson gson = new Gson();
    public static JsonParser parser = new JsonParser();

    public static Venue saveVenue(JsonObject input_venue, Boolean create) {
        Venue saved_venue = gson.fromJson(input_venue, Venue.class);

        if (create){ saved_venue.createMapping();}
        try (Writer writer = new FileWriter("./venues/"+input_venue.get("name").getAsString()+".json")) {
            Gson builder_gson = new GsonBuilder().create();
            builder_gson.toJson(saved_venue, writer);

            System.out.println("saved a venue");
            System.out.println(saved_venue);
            return saved_venue;
        } catch (IOException write_excp) {
            System.out.println("error saving venue");
            write_excp.printStackTrace();
        }

        return null;
    }

    public static Venue loadVenue(JsonObject input_venue) {
        try (JsonReader jsonReader = new JsonReader( new FileReader("./venues/"+input_venue.get("name").getAsString()+".json"))) {
            System.out.println("file found");

            return gson.fromJson(jsonReader, Venue.class);
        } catch (FileNotFoundException read_excp) {
            System.out.println("could not find venue; creating...");
            return saveVenue(input_venue, true);
        } catch (IOException io_excep) {
            System.out.println("error reading file");
            io_excep.printStackTrace();
        }

        return null;
    }

    public static void loseSeat(Venue venue, Integer row, Integer column) {

        Calendar cal = Calendar.getInstance();
        Date date = new Date(cal.getTimeInMillis() + 5000); // set to 5 seconds

        // TODO need to handle edge case where someone reserves while timer is running
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                venue.seat(row, column, false);
                saveVenue(parser.parse(gson.toJson(venue)).getAsJsonObject(), false);

                System.out.println("moved your meat");
            }
        }, date);
    }

    public static void doActions(JsonObject actions, Venue venue) {
        Integer row = actions.get("row").getAsInt();
        Integer column = actions.get("column").getAsInt();

        switch (actions.get("verb").getAsString()){
            case "reserve":
                System.out.println("reserving row "+row+" and column "+column);

                venue.seat(row, column, true);

                saveVenue(parser.parse(gson.toJson(venue)).getAsJsonObject(), false);

                break;
            case "hold":
                System.out.println("holding row "+row+" and column "+column+" for 2 seconds");

                venue.seat(row, column, true);
                saveVenue(parser.parse(gson.toJson(venue)).getAsJsonObject(), false);

                loseSeat(venue, row, column);

                break;
            case "show":
                System.out.println("showing venue seating");

                venue.show();

                break;
            default:
                System.out.println(":'( no action provided");
                break;
        }
    }

	public static void main(String[] args) throws Exception {
        JsonObject json_input = parser.parse(args[0]).getAsJsonObject();
        try {
            JsonObject input_venue = json_input.getAsJsonObject("venue");
            Venue my_venue = loadVenue(input_venue);
            if (my_venue != null) {
                JsonObject action = json_input.getAsJsonObject("action");
                System.out.println(action);
                doActions(action, my_venue);
            } else {
                throw new Exception("I have no venue to do work on");
            }
        } catch (NullPointerException e) {
            // ehh i can probably catch more stuff and make it pretty
            throw new Exception("venue object must exist; action object is optional");
        }
//		SpringApplication.run(PocApplication.class, args);
	}
}
