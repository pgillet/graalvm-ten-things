import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;

public class GcdJavaSharedLib {

    @CEntryPoint(name = "get_gcd")
    public static long getGCD(IsolateThread thread, long a, long b) {
        return GCD.getGCD(a, b);
    }

    public static void main(String[] args) {
    }
    
}
