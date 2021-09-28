#!/usr/bin/env bash
. ../utils/bash-env.sh

echo "Install Java on Truffle"
$GRAALVM_CE_HOME/bin/gu install espresso
$GRAALVM_CE_HOME/bin/gu list

$GRAALVM_CE_HOME/bin/java -truffle -version

echo "Run Java on Truffle"
cat HelloWorld.java

echo "Start running applications"
$GRAALVM_CE_HOME/bin/javac HelloWorld.java
$GRAALVM_CE_HOME/bin/java -truffle HelloWorld

cd spring-petclinic/
git remote -v
mvn package -DskipTests

$GRAALVM_CE_HOME/bin/java -truffle -jar target/spring-petclinic-*.jar
