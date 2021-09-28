#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "The native image can be built as follows:\n\e[97m\e[1m> mvn -Pnative -DskipTests package"

echo "Run the native application"
target/rest-service-complete

# Test the native application
# curl localhost:8080/greeting

