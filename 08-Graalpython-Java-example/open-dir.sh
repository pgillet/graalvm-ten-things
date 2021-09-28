#!/usr/bin/env bash

SCRIPT_DIR="$(dirname ${BASH_SOURCE[0]})"

cd ${SCRIPT_DIR}

# rationale-pick-most-suitable-language.png \
# rationale-migrate-code.png \

code -r . \
rationale-language-domains.png \
graalpython-java-example/src/main/java/com/oracle/example/javapython/Main.java \
graalpython-java-example/src/main/java/com/oracle/example/javapython/SVGCanvas.java \
graalpython-java-example/src/main/java/com/oracle/example/javapython/GraphRenderer.java \
graalpython-java-example/src/main/resources/pygalrenderer.py \
graalpython-java-example/pom.xml \
run.sh
