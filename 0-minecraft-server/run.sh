#!/usr/bin/env bash

# java -Xms1G -Xmx7G -jar server.jar nogui

# Edit the eula.txt file

$GRAALVM_CE_HOME/bin/java -agentlib:native-image-agent=config-output-dir=./config-dir/ -jar server.jar nogui

$GRAALVM_CE_HOME/bin/native-image -jar server.jar minecraft-server -H:ConfigurationFileDirectories=./config-dir/ --no-fallback --allow-incomplete-classpath --enable-url-protocols=https -H:Log=registerResource:verbose