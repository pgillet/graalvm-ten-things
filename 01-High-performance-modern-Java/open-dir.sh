#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . graalvm-ad.png graalvm-ce-ee.png TopTen.java alice.txt run.sh
