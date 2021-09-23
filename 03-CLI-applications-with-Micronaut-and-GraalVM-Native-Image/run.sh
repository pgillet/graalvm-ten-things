#!/usr/bin/env bash
source ../utils/bash-env.sh

echo "Build JAR"
./gradlew build

echo "Run JAR"
/usr/bin/time -v $GRAALVM_CE_HOME/bin/java -jar build/libs/primes-0.1-all.jar -n 1 -l 100

echo "Build Native Image"
JAVA_HOME=${GRAALVM_CE_HOME}
./gradlew nativeImage

echo "Run Native Image"
/usr/bin/time -v build/native-image/application -n 1 -l 100
