
// Reverse Vowels of a String
// two pointers - awesome approach
class Solution {

    public String reverseVowels(String s) {
        
        if(s == null || s.length()==0) return s;

        int i = 0 ; int j = s.length() - 1;

        String vowels = "aeiouAEIOU";

        char[] temp = s.toCharArray();

        while(i < j){


            while(i < j && !vowels.contains(temp[i] + "")) i++;

            while(i < j && !vowels.contains(temp[j] +"")) j--;

            char cur  = temp[i];
            temp[i] = temp[j];
            temp[j] = cur;

            i++;
            j--;
        }

        return new String(temp);

        
    }
}

