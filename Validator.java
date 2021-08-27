
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Validator {

    /**
     * Will be automatically included by the "linker" in the native image.
     */
    private static final String VALIDATOR_NPM_MODULE_PATH = "node_modules/validator/validator.js";
    private static final Logger logger = Logger.getLogger(Validator.class.getName());

    private final Engine engine;
    private final Source source;

    public Validator() throws IOException {

        engine = Engine.create();
        source = Source.newBuilder("js", new File(System.getProperty("java.home"), VALIDATOR_NPM_MODULE_PATH)).build();
        try (Context context = Context.newBuilder().engine(engine).build()) {
            context.eval(source);
            logger.fine(context.getBindings("js").getMemberKeys().toString());
            Value validator = context.getBindings("js").getMember("validator");
            Set<String> memberKeys = validator.getMemberKeys();
            logger.fine(memberKeys.toString());
            assert memberKeys.contains("isEmail");
        }
    }

    private boolean doValidate(String function, Object... args) {
        try (Context context = Context.newBuilder().engine(engine).build()) {
            context.eval(source);
            Value validator = context.getBindings("js").getMember("validator");
            Value funcValidator = validator.getMember(function);
            boolean result = funcValidator.execute(args).asBoolean();
            logger.fine(String.format("%s \"%s\" = %b", function, args[0], result));
            return result;
        }
    }

    public boolean isEmail(String str) {
        return doValidate("isEmail", str);
    }

    public boolean isLatLong(String str) {
        return doValidate("isLatLong", str);
    }

    public boolean isCreditCard(String str) {
        return doValidate("isCreditCard", str);
    }

    public boolean isMobilePhone(String str) {
        return doValidate("isMobilePhone", str);
    }

    public boolean isURL(String str) {
        return doValidate("isURL", str);
    }

    public boolean isBIC(String str) {
        return doValidate("isBIC", str);
    }

    public boolean isPostalCode(String str) {
        return doValidate("isPostalCode", str, "FR");
    }

    public boolean isCurrency(String str) {
        return doValidate("isCurrency", str);
    }

    public boolean isIP(String str) {
        return doValidate("isIP", str);
    }

    public static void main(String[] args) throws IOException {
        String function = args[0];
        String value = args[1];

        Validator validator = new Validator();

        boolean result = validator.doValidate(function, value);
        System.out.printf("%s %s = %b\n", function, value, result);
    }

}
