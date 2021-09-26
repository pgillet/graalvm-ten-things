public class GCD {

    public static long getGCD(long a, long b){

        while (b != 0){
            if (a > b)
                a = a - b;
            else 
                b = b - a;
        }

        return a;
    }
    
}
