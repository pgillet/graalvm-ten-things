JAVA_HOME=${GRAALVM_CE_HOME}

build:
	${GRAALVM_CE_HOME}/bin/gu install python
	mvn compile -f graalpython-java-example/

clean:
	mvn clean -f graalpython-java-example/