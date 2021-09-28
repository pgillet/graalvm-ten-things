#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Generate small text file"
make small.txt
du -h small.txt

echo "Compile"
$GRAALVM_CE_HOME/bin/javac TopTen.java

echo "Run with GraalVM CE"
/usr/bin/time -v $GRAALVM_CE_HOME/bin/java TopTen small.txt

echo "Build native image"
$GRAALVM_CE_HOME/bin/native-image --no-server --no-fallback TopTen

echo "Inspect the shared libraries used by the topten native executable \U1F9D0"
ldd topten

echo "topten file space usage"
du -h topten

echo "Run the executable"
/usr/bin/time -v ./topten small.txt

# echo "Again, but with a large text input file"
# make large.txt
# /usr/bin/time -v ./topten large.txt