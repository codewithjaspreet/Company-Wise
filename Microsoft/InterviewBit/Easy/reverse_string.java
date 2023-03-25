public class Solution {
    public String solve(String A) {
        A = A.replaceAll("( )+", " ");
        A = A.trim();
        String[] str = A.split(" ");
        String result ="";
        for(int i= str.length-1;i>=0;i--)
            result = result +" " +str[i];
        return result.trim();    
    }
}