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

`make OPTIONS="'{"venue":{"name": "echostage", "rows": 4, "columns": 5}}'" run`

#### Show Seats

`make OPTIONS="'{"venue":{"name": "echostage"}, "action"{"verb": "show"}}'" run`

#### Reserve Seats

`make OPTIONS="'{"venue":{"name": "echostage"}, "action"{"verb": "reserve", "row": 1, "column": 3}}'" run`

#### Hold Seats (holds for 5 seconds)

`make OPTIONS="'{"venue":{"name": "echostage"}, "action"{"verb": "hold", "row": 1, "column": 3}}'" run`
