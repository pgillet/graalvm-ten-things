#!/usr/bin/env bash
source ../utils/bash-env.sh

cecho Gs "Generate large text file"
make large.txt

cecho Gs "\nCompile"
$GRAALVM_EE_HOME/bin/javac TopTen.java

cecho Gs "\nRun with GraalVM EE \U1F680"
time $GRAALVM_EE_HOME/bin/java TopTen large.txt

# cecho "\nRun with GraalVM without the GraalVM JIT compiler"
# time $GRAALVM_EE_HOME/bin/java -XX:-UseJVMCICompiler TopTen large.txt

cecho Gs "\nRun with standard HotSpot JVM \U1F40C"
time $JAVA_HOME/bin/java TopTen large.txt