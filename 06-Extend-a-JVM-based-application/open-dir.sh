#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . use-case-input-validation.png \
rationale-reuse-code.png \
node_modules/validator/validator.js \
Validator.java \
run.sh
