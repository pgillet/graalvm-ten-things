#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Compile"
$GRAALVM_CE_HOME/bin/javac -cp commons-text-1.9.jar -parameters Distance.java

echo "Calculate some Levenshtein distances \U1F4CF"
$GRAALVM_CE_HOME/bin/java -cp commons-text-1.9.jar:. Distance gruik gruik
$GRAALVM_CE_HOME/bin/java -cp commons-text-1.9.jar:. Distance exemple example
$GRAALVM_CE_HOME/bin/java -cp commons-text-1.9.jar:. Distance kitten sitten
$GRAALVM_CE_HOME/bin/java -cp commons-text-1.9.jar:. Distance Honda Hyundai
$GRAALVM_CE_HOME/bin/java -cp commons-text-1.9.jar:. Distance clock clone

echo "Build native executable"
$GRAALVM_CE_HOME/bin/native-image --no-server --no-fallback -cp commons-text-1.9.jar:. Distance

echo "Test native executable"
./distance gruik grok