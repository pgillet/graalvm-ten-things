import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;

public class GcdJava {

    public static void main(String[] args) {

        long a  = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);

        while (b != 0){
            if (a > b)
                a = a - b;
            else 
                b = b - a;
        }

        System.out.format("GCD of %s and %s is %d", args[0], args[1], a);
    }
    
}
