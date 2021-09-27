#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

code -r . rationale-pick-most-suitable-language.png rationale-migrate-code.png rationale-language-domains.png run.sh
