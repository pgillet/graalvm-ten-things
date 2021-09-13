#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"
# source ${SCRIPT_DIR}/bash-spinner/spinner.sh

set -eu

function echo() {
    command echo -e "\n\e[3m\e[32m# $1\e[0m"
}

function process_command() {
# Print commands except echo commands
if [[ $BASH_COMMAND != echo* ]]; then
    printf "\e[1m%s\e[0m\n" "$BASH_COMMAND"
    read -n 1 -p $'\e[90mPress any key to continue\e[0m'
fi
#    start_spinner ""
}

trap process_command DEBUG

