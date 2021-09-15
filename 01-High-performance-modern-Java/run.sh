#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Generate large text file \U1F4DD"
make large.txt

echo "Compile \U2699"
$GRAALVM_EE_HOME/bin/javac TopTen.java

echo "Run with GraalVM EE \U1F680"
time $GRAALVM_EE_HOME/bin/java TopTen large.txt

# echo "Run with GraalVM without the GraalVM JIT compiler"
# time $GRAALVM_EE_HOME/bin/java -XX:-UseJVMCICompiler TopTen large.txt

echo "Run with standard HotSpot JVM \U1F6AC"
time $JAVA_HOME/bin/java TopTen large.txt