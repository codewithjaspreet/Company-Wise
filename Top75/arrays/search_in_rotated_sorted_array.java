package Top75. arrays;

import java.util.Scanner;


public class search_in_rotated_sorted_array {

    public int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;

            // this means low to mid part is sorted

            if (arr[mid] == target)
                return mid;
            if (arr[low] <= arr[mid]) {

                if (target >= arr[low] && arr[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            else if

            (arr[mid] <= arr[high]) {

                if (target > arr[mid] && target <= arr[high]) {

                    low = mid + 1;
                }

                else
                    high = mid - 1;
            }

        }

        return -1;

    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);



    }
}
