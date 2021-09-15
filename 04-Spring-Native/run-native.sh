#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Run the native application"
target/rest-service-complete

# Test the native application
# curl localhost:8080/greeting

