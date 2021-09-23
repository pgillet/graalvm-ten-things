#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Run the native application"
target/rest-service-complete

# Test the native application
# curl localhost:8080/greeting

