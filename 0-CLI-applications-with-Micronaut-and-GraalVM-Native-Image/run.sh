#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Build JAR"
./gradlew build

cecho Gs "\nRun JAR"
/usr/bin/time -v $GRAALVM_CE_HOME/bin/java -jar build/libs/primes-0.1-all.jar -n 1 -l 100

cecho Gs "\nBuild Native Image"
./gradlew nativeImage -Dorg.gradle.java.home=$GRAALVM_CE_HOME -Djava.vendor.version=graal

cecho Gs "\nRun Native Image"
/usr/bin/time -v build/native-image/application -n 1 -l 100