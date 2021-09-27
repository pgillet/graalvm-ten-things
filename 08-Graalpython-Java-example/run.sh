#!/usr/bin/env bash
. ../utils/bash-env.sh

${GRAALVM_CE_HOME}/bin/gu install python

cd graalpython-java-example/

echo "Compile"
mvn compile

echo "Run the example"
mvn exec:exec
