#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Run the standard Spring Boot application"
java -jar target/rest-service-complete-0.0.1-SNAPSHOT-exec.jar

# Test the native application
# curl localhost:8080/greeting

