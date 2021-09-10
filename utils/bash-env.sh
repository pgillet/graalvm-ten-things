#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"
source ${SCRIPT_DIR}/bash-colors/bash-colors.sh

set -eu

function process_command() {
# Print commands except echo commands
if [[ $BASH_COMMAND != cecho* ]]; then
    echo $BASH_COMMAND
    read -n 1 -p $'\e[90mPress any key to continue\e[0m'
fi
}

trap process_command DEBUG

