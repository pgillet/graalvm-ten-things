JAVA_HOME=${GRAALVM_CE_HOME}
SL_BUILD_NATIVE=true

build:
	${GRAALVM_CE_HOME}/bin/gu install native-image
	mvn package -DskipTests -f simplelanguage/

clean:
	mvn clean -f simplelanguage/