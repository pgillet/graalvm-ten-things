
import org.apache.commons.text.similarity.LevenshteinDistance;

public class Distance {
    
    public static void main(String[] args) {
        final String str1 = args[0];
        final String str2 = args[1];

        Integer result = LevenshteinDistance.getDefaultInstance().apply(str1, str2);
        System.out.println(result);
    }

}
