public class Solution {

    // brute force O(N) space  and O(N) time

    public int majorityElement(final int[] A) {
        
        int ans = -1;
        
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int a : A ){
            
            map.put(a , map.getOrDefault(a , 0 ) + 1);
        }
        
        
        
        for(int  a : map.keySet()){
            
            if(map.get(a) > A.length / 2){
                
                ans = a;
                break;
            }
        }
        
        return ans;
    }
}
