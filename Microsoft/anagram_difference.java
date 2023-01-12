import java.util.*;

public class anagram_difference {
    public static int getMinimumAnagramDifference(String str1, String str2) {
        // Write your code here.

        int[] arr = new int[26];

        for (char c : str1.toCharArray())
            arr[c - 'a']++;

        for (char c : str2.toCharArray())
            arr[c - 'a']--;

        int c = 0;

        for (int a : arr) {

            if (a > 0)
                c += a;
        }

        return c;

    }
}