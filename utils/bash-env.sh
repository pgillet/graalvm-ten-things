#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

set -eu

function echo() {
    command echo -e "\n\e[3m\e[32m# $1\e[0m"
}

function process_command() {
# Print commands except echo commands
if [[ $BASH_COMMAND != echo* ]]; then
    printf "\e[1m%s\e[0m\n" "$BASH_COMMAND"
    read -p $'\e[90mPress enter to continue\e[0m'
fi
}

trap process_command DEBUG

