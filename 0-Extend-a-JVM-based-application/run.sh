#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Compile"
$GRAALVM_CE_HOME/bin/javac Validator.java

cecho Gs "Install validator.js"
$GRAALVM_CE_HOME/bin/npm install validator

cecho Gs "Test"
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal.gillet@stack-labs.com
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal-dot-gillet-at-stack-labs-dot-com