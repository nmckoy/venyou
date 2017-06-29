```                                                                  
       ,---.                                 ,---,                           
      /__./|                  ,---,         /_ ./|    ,---.            ,--,  
 ,---.;  ; |              ,-+-. /  |  ,---, |  ' :   '   ,'\         ,'_ /|
/___/ \  | |    ,---.    ,--.'|'   | /___/ \.  : |  /   /   |   .--. |  | :
\   ;  \ ' |   /     \  |   |  ,"' |  .  \  \ ,' ' .   ; ,. : ,'_ /| :  . |
 \   \  \: |  /    /  | |   | /  | |   \  ;  `  ,' '   | |: : |  ' | |  . .  
  ;   \  ' . .    ' / | |   | |  | |    \  \    '  '   | .; : |  | ' |  | |  
   \   \   ' '   ;   /| |   | |  |/      '  \   |  |   :    | :  | : ;  ; |  
    \   `  ; '   |  / | |   | |--'        \  ;  ;   \   \  /  '  :  `--'   \ 
     :   \ | |   :    | |   |/             :  \  \   `----'   :  ,      .-./ 
      '---"   \   \  /  '---'               \  ' ;             `--`----' 
               `----'                        `--`                            
```
______________________________________________________________________________

# VenYou!
(name already exists :/)
save a seat. watch something cool.

## Build
to setup and build, use `make`:

`make`

## Run
There are various options to run. VenYou takes a json string from the command line to do various actions.

#### Create Venue

`java -jar target/poc-0.0.1-SNAPSHOT.jar '{"venue":{"name": "echostage", "rows": 4, "columns": 5}}'`

#### Show Seats

`java -jar target/poc-0.0.1-SNAPSHOT.jar '{"venue":{"name": "echostage"}, "action"{"verb": "show"}}'`

#### Reserve Seats

`java -jar target/poc-0.0.1-SNAPSHOT.jar '{"venue":{"name": "echostage"}, "action"{"verb": "reserve", "row": 1, "column": 3}}'`

#### Hold Seats (holds for 5 seconds)

`java -jar target/poc-0.0.1-SNAPSHOT.jar '{"venue":{"name": "echostage"}, "action"{"verb": "hold", "row": 1, "column": 3}}'`
