#!/bin/bash

# JAVA AS A NATIVE LIBRARY

echo "-- Clean..."
rm *.jar *.class *.h *.so
echo

echo "-- Make GCD jar library"
jar cvf GCD.jar GCD.java
echo

echo "-- Build the Java native shared library"
javac -cp GCD.jar GcdJavaSharedLib.java
echo

echo "-- Compile to a shared library"
native-image --no-server -cp GCD.jar:. --shared -H:Name=libgcd
echo

echo "-- Compile C program that uses the library"
clang -I. -L. -lgcd gcd.c -o gcd
echo

echo "-- Execute the C program with success"
printf 'Please Demo Gods \U1F64F\n'
./gcd 234 548








