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

    public static int majorityElement2(int[] arr){

        int ansIndex  = 0;
        int count = 1;

        for(int i = 1; i < arr.length ; i++){

            if(arr[ansIndex] == arr[i]){

                count++;
            }
            else count--;

            if(count == 0){

                ansIndex = i;
                count = 1;
            }
        }

        int temp = 0;
        for(int i = 0 ; i < arr.length ; i++){

            if(arr[i] == arr[ansIndex]){

                temp++;
            }
        }

        if(temp > arr.length / 2) return arr[ansIndex];
        else return -1;

    }
}
