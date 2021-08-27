#!/bin/bash

javac GcdJava.java

native-image --no-server --no-fallback GcdJava

./gcdjava 456 789