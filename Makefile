all: build run

build:
	mvn package
run:
	java -jar target/poc-0.0.1-SNAPSHOT.jar '{"venue":{"name": "nick", "rows": 2, "columns": 2}, "action": {"verb": "show", "row": 1, "column": 2}}'
