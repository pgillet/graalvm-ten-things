#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . micronaut-weather-cli/src/main/java/weather/cli/WeatherCommand.java \
micronaut-weather-cli/src/main/java/weather/cli/api/WeatherClient.java \
micronaut-weather-cli/build.gradle \
run.sh
