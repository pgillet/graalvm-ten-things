#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Test Validator \U1F91E"
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal.gillet@stack-labs.com
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal-dot-gillet-at-stack-labs-dot-com
$GRAALVM_CE_HOME/bin/java Validator isIP 127.0.0.1
$GRAALVM_CE_HOME/bin/java Validator isIP 127.0.0.999