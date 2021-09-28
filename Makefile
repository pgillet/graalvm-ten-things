TOPTARGETS := clean build

SUBDIRS := ./01-High-performance-modern-Java ./02-Low-footprint-fast-startup-Java ./03-CLI-applications-with-Micronaut-and-GraalVM-Native-Image ./04-Spring-Native ./05-Run-native-languages-on-the-JVM ./06-Extend-a-JVM-based-application ./07-Java-code-as-native-library ./08-Graalpython-Java-example ./09-Simple-Language ./10-Espresso-Java-on-Truffle 

$(TOPTARGETS): $(SUBDIRS)
$(SUBDIRS):
	$(MAKE) -C $@ $(MAKECMDGOALS)

.PHONY: $(TOPTARGETS) $(SUBDIRS)
