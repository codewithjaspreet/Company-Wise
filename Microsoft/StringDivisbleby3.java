package Microsoft;

public class StringDivisbleby3 {
    
    // a string is divisible by 3 if the difference between the sum of odd and even digits is divisible by 3
    
    static int isDivisible(String str) {
        
        int odd = 0;

        int even = 0;

        for (int i = 0; i < str.length(); i++) {

            if (i % 2 == 0)
                even += str.charAt(i) - '0';
            else
                odd += str.charAt(i) - '0';
        }

        return (Math.abs(odd - even) % 3 == 0) ? 1 : 0;

    }
}
