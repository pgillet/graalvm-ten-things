#!/usr/bin/env bash

. ../utils/bash-env.sh

echo "Build"
cd simplelanguage/
git remote -v
export SL_BUILD_NATIVE=false
export JAVA_HOME=$GRAALVM_CE_HOME
mvn package -DskipTests

echo "Run examples"
cat language/tests/HelloWorld.sl

$GRAALVM_CE_HOME/bin/java \
    -cp launcher/target/launcher-21.2.0.jar \
    -Dtruffle.class.path.append=language/target/simplelanguage.jar \
    com.oracle.truffle.sl.launcher.SLMain language/tests/HelloWorld.sl

more sl
./sl language/tests/HelloWorld.sl

cat language/tests/SumPrint.sl
./sl language/tests/SumPrint.sl

cat language/tests/Fibonacci.sl
./sl language/tests/Fibonacci.sl

echo "Simple Language Component for GraalVM"
du -h component/sl-component.jar
$GRAALVM_CE_HOME/bin/gu -L install component/sl-component.jar
$GRAALVM_CE_HOME/bin/gu list

echo "Simple Language Native Image"
du -h ./native/slnative
time ./sl language/tests/HelloWorld.sl
time ./native/slnative language/tests/HelloWorld.sl
