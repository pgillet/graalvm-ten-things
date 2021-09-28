#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . Distance.java run-1.sh SharedDistance.java distance.c run-2.sh
