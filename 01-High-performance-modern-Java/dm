#!/usr/bin/env bash
. ../utils/demo-magic/demo-magic.sh

# hide the evidence
clear

 # Generate large text file
pe 'make large.txt'

# Compile
pe '$GRAALVM_EE_HOME/bin/javac TopTen.java'

# Run with GraalVM EE
pe 'time $GRAALVM_EE_HOME/bin/java TopTen large.txt'

# Run with GraalVM without the GraalVM JIT compiler
# pe 'time $GRAALVM_EE_HOME/bin/java -XX:-UseJVMCICompiler TopTen large.txt'

# Run with standard HotSpot JVM
pe 'time $JAVA_HOME/bin/java TopTen large.txt'