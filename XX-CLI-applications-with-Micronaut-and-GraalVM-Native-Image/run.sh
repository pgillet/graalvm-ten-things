#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Build JAR"
./gradlew clean build

export WEATHER_API_KEY=c8d35938f3e9430f8cda6aba0d216316

echo "Run JAR"
$GRAALVM_CE_HOME/bin/java -jar build/libs/weather-0.1-all.jar -h

$GRAALVM_CE_HOME/bin/java -jar build/libs/weather-0.1-all.jar --city Toulouse

echo "Build Native Image"
JAVA_HOME=${GRAALVM_CE_HOME}
./gradlew nativeImage

echo "Run Native Image"
build/native-image/application -h

build/native-image/application

build/native-image/application --city Toulouse

build/native-image/application --city Toulouse --forecast 10
