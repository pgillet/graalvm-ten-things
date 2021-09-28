#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . jit-aot.png TopTen.java run.sh
