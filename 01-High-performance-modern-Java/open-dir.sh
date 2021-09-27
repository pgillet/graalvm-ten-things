#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . title.png java-ecosystem.png graalvm-ad.png graalvm-ce-ee.png TopTen.java Makefile run.sh
