#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

source ${SCRIPT_DIR}/bash-colors/bash-colors.sh

set -eu

# Print commands except echo commands
trap '[[ $BASH_COMMAND != cecho* ]] && echo $BASH_COMMAND' DEBUG
