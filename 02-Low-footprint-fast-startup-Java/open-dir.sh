#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

code -r ${SCRIPT_DIR} TopTen.java Makefile run.sh
