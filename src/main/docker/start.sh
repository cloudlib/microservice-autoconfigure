#!/usr/bin/env bash
/wait-for-it.sh -t 120 -h discovery -p 8761
/wait-for-it.sh -t 120 -h configserver -p 8888
java -jar /app.jar