package com.venyou.poc;

import lombok.Data;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BooleanSupplier;

/**
 * Created by mckoyn on 6/29/17.
 */
@Data
public class Venue {

    private String name;
    private Integer rows;
    private Integer columns;

    private HashMap<Integer, HashMap<Integer, Boolean>> mapping;

    public void createMapping() {
        HashMap<Integer, HashMap<Integer, Boolean>> local_mapping = new HashMap<>();
        for (int i = 1; i <= rows; i++) {
            local_mapping.put(i, new HashMap<>());
            for (int j = 1; j <= columns; j++) {
                local_mapping.get(i).put(j, false);
            }
        }
        mapping = local_mapping;
    }

    public void seat(Integer row, Integer column, Boolean meat) {
        if (row <= rows | column <= columns) {
            HashMap new_mapping = this.mapping;
            HashMap changed_row = (HashMap<Integer, Boolean>) new_mapping.get(1);
            changed_row.put(column, meat);
            new_mapping.put(row, changed_row);

            mapping = new_mapping;
        } else {
            System.out.println("that seat does not exist; use show to find available seats");
        }

    }

    public void show() {
        String map = "";
        Set row_keys = mapping.keySet();
        for (Object row_key : row_keys) {
            HashMap row = mapping.get(row_key);
            Set column_keys = row.keySet();
            for (Object column_key : column_keys) {
                if (row.get(column_key).equals(false)) {
                    map += "O ";
                } else {
                    map += "X ";
                }

            }
            map += "\n";
        }
        System.out.println(map);
    }
}
