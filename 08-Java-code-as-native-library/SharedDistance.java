
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CTypeConversion;

public class SharedDistance {
    
    @CEntryPoint(name = "distance")
    public static int distance(IsolateThread thread, CCharPointer ptr1, CCharPointer ptr2) {
        //Convert C *char to Java String
        final String str1 = CTypeConversion.toJavaString(ptr1);
        final String str2 = CTypeConversion.toJavaString(ptr2);

        Integer result = LevenshteinDistance.getDefaultInstance().apply(str1, str2);
        return result;
    }
}
