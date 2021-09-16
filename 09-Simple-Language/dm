#!/usr/bin/env bash
. ../utils/demo-magic/demo-magic.sh

# hide the evidence
clear

# Setup
pe '$GRAALVM_EE_HOME/bin/gu list'
pe '$GRAALVM_EE_HOME/bin/gu install native-image'

# Build
pe 'export SL_BUILD_NATIVE=false'
pe 'du -h ./native/slnative'
pe 'export JAVA_HOME=$GRAALVM_CE_HOME'
pe 'mvn package'

# Run examples
pe 'cat language/tests/HelloWorld.sl'
$JAVA_HOME/bin/java \
    -cp launcher/target/launcher-21.2.0-SNAPSHOT.jar \
    -Dtruffle.class.path.append=language/target/simplelanguage.jar \
    com.oracle.truffle.sl.launcher.SLMain language/tests/HelloWorld.sl
pe 'more sl'
pe './sl language/tests/HelloWorld.sl'

pe 'cat language/tests/SumPrint.sl'
pe './sl language/tests/SumPrint.sl'

pe 'cat language/tests/Fibonacci.sl'
pe './sl language/tests/Fibonacci.sl'

# Simple Language Component for GraalVM
pe 'du -h component/sl-component.jar'
pe '$GRAALVM_EE_HOME/bin/gu -L install component/sl-component.jar'
pe '$GRAALVM_EE_HOME/bin/gu list'

# Simple Language Native Image
pe 'time ./sl language/tests/HelloWorld.sl'
pe 'time ./native/slnative language/tests/HelloWorld.sl'
