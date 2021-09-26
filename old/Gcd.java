import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class Gcd {
    public static void main(String[] args) {
        try (Context context = Context.create()) {
            Value jsBindings = context.getBindings("js");
            jsBindings.putMember("a", args[0]);
            jsBindings.putMember("b", args[1]);
            context.eval("js",    
                   "while (b != 0){   " +
                   "  if (a > b)      " +
                   "    a = a - b;    " +
                   "  else            " + 
                   "    b = b - a;    " +
                   "}");
            int gcd = jsBindings.getMember("a").asInt();
            System.out.format("GCD of %s and %s is %d", args[0], args[1], gcd);
        }
    }
    
}
