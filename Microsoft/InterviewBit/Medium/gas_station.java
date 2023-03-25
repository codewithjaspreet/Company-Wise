public class Solution {

    // O(N) time and O(1) space
    public int canCompleteCircuit(final int[] A, final int[] B) {
        
        int start  = 0;
        int cur = 0;
        
        int total_gas = 0;
        int total_cost = 0;
        
        
        for(int a : A) total_gas+= a;   
        for(int a : B) total_cost+=a;
        
        if(total_gas < total_cost) return -1;
        
        
        for(int i = 0 ; i < A.length ;i++) {
            
            cur += (A[i] - B[i]);
            
            if(cur < 0){
                start = i+1;
                cur = 0;
            }
            
        }
        
        return start;
        
        
        
        
    }
}
