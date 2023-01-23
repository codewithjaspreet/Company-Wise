import java.util.ArrayList;
import java.util.Arrays;

public class merge_intervals {
        public int[][] merge(int[][] intervals) {

            // sort on start point - lambda usage
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            ArrayList<int[]> arr = new ArrayList<>();

            for (int[] interval : intervals) {

                if (arr.size() == 0)
                    arr.add(interval);

                else {

                    int[] prev = arr.get(arr.size() - 1);

                    if (interval[0] <= prev[1])
                        prev[1] = Math.max(interval[1], prev[1]);

                    else
                        arr.add(interval);

                }
            }
             
            // converting an ArrayList of arrays of integers (arr) into a regular 2D array
            return arr.toArray(new int[arr.size()][]);
        }
    }
