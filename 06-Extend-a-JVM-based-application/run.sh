#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Build \U2699"
${GRAALVM_CE_HOME}/bin/npm install validator
${GRAALVM_CE_HOME}/bin/javac Validator.java

echo "Test Validator \U1F91E"
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal.gillet@stack-labs.com
$GRAALVM_CE_HOME/bin/java Validator isEmail pascal-dot-gillet-at-stack-labs-dot-com
$GRAALVM_CE_HOME/bin/java Validator isIP 127.0.0.1
$GRAALVM_CE_HOME/bin/java Validator isIP 127.0.0.999
$GRAALVM_CE_HOME/bin/java Validator isURL https://fr.wikipedia.org/
$GRAALVM_CE_HOME/bin/java Validator isURL gruik
$GRAALVM_CE_HOME/bin/java Validator isMobilePhone +33678910111
$GRAALVM_CE_HOME/bin/java Validator isMobilePhone +3367891011