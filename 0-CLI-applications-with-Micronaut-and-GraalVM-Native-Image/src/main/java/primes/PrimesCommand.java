package primes;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import javax.inject.*;
import java.util.*;
@Command(name = "primes", description = "...",
        mixinStandardHelpOptions = true)
public class PrimesCommand implements Runnable {
    @Option(names = {"-n", "--n-iterations"}, description = "How many iterations to run")
    int n;
    
    @Option(names = {"-l", "--limit"}, description = "Upper limit for the sequence")
    int l;
    
    @Inject
    PrimesComputer primesComputer; 
    
    public static void main(String[] args) throws Exception {
        PicocliRunner.run(PrimesCommand.class, args);
    }
    public void run() {
        for(int i =0; i < n; i++) {
            List<Long> result = primesComputer.random(l);
            System.out.println(result);
        }
    }
}