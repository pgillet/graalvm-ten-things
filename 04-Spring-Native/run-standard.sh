#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Build"
JAVA_HOME=${GRAALVM_CE_HOME}
mvn -DskipTests package

echo "Run the standard Spring Boot application"
java -jar target/rest-service-complete-0.0.1-SNAPSHOT-exec.jar

# Test the native application
# curl localhost:8080/greeting

