large.txt: alice.txt
	for i in $(shell seq 1000); do cat $< >> $@; done

small.txt: alice.txt
	head -c 1024 $< > $@

clean:
	rm -f large.txt small.txt *.h *.class *.bc *.json unicalc topten
