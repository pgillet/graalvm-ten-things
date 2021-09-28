#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . src/main/java/com/example/restservice/RestServiceApplication.java \
src/main/java/com/example/restservice/GreetingController.java \
src/main/java/com/example/restservice/Greeting.java \
pom.xml \
run-standard.sh \
run-native.sh
