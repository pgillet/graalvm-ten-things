import java.io.IOException;
import java.io.InputStreamReader;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Validator {

    /**
     * Will be automatically included by the "linker" in the native image.
     */    
    private static String VALIDATOR_NPM_MODULE_PATH = "node_modules/validator/validator.js";
    private static String JAVASCRIPT = "js";
    private Value validator;


    public Validator() throws IOException {
        Context context = Context.newBuilder(JAVASCRIPT).build();
        InputStreamReader code = new InputStreamReader(Validator.class.getClassLoader().getResourceAsStream(VALIDATOR_NPM_MODULE_PATH));
        Source source = Source.newBuilder(JAVASCRIPT, code, VALIDATOR_NPM_MODULE_PATH).build();
        context.eval(source);
        validator = context.getBindings(JAVASCRIPT).getMember("validator");
    }

    private boolean doValidate(String function, Object... args) {
        Value funcValidator = validator.getMember(function);
        boolean result = funcValidator.execute(args).asBoolean();
        return result;
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
