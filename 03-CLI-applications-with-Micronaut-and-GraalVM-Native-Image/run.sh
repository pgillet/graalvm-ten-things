#!/usr/bin/env bash
. ../utils/bash-env.sh

cd micronaut-weather-cli/

echo "Build JAR"
./gradlew build

echo "Run JAR"
$GRAALVM_CE_HOME/bin/java -jar build/libs/weather-0.1-all.jar -h

echo "Build Native Image"
JAVA_HOME=${GRAALVM_CE_HOME}
./gradlew nativeImage

echo "Run Native Image"
mv build/native-image/application weather
./weather -h

./weather

./weather --city Toulouse

./weather --city Toulouse --forecast 10
