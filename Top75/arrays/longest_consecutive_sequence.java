package Top75.arrays;
import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int a : nums) {
            map.put(a, true);
        }

        for (int a : nums) {
            if (map.containsKey(a - 1)) {
                map.put(a, false);
            }
        }

        int msp = 0;
        int ml = 0;
        for (int a : nums) {
            if (map.get(a) == true) {
                int tl = 1;
                int tsp = a;
                while (map.containsKey(tsp + tl)) {
                    tl++;
                }

                msp = Math.max(msp, tsp);
                ml = Math.max(ml, tl);

            }
        }
        return ml;

    }
}