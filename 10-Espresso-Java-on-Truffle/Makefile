JAVA_HOME=${GRAALVM_CE_HOME}

build:
	${GRAALVM_CE_HOME}/bin/gu install espresso
	mvn package -DskipTests -f spring-petclinic/

clean:
	mvn clean -f spring-petclinic/