#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Clean \U1F9F9"
make clean

echo "Compile"
$GRAALVM_CE_HOME/bin/javac -cp commons-text-1.9.jar -parameters SharedDistance.java

echo "Build shared library"
$GRAALVM_CE_HOME/bin/native-image --no-server -cp commons-text-1.9.jar:. --shared -H:Name=libdistance

echo "Inspect the shared library \U1F9D0"
ldd libdistance.so

du -h libdistance.so

echo "Compile distance.c with standard system tools"
LD_LIBRARY_PATH=.

clang -I. -L. -ldistance distance.c -o distance

echo "Inspect the shared library \U1F9D0"
ldd distance

echo "Test native executable"
./distance gruk grek

