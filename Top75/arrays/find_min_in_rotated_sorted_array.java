package Top75.arrays;

// find mid
// low to mid  - part 1  , mid to high - part 2

// ans will always be in the unsorted region try going there

public class find_min_in_rotated_sorted_array {
    
        public int findMin(int[] nums) {

            int low = 0;
            int high = nums.length - 1;

            if (nums[low] <= nums[high])
                return nums[0];

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (nums[mid] > nums[mid + 1])
                    return nums[mid + 1];

                else if (nums[mid - 1] > nums[mid])
                    return nums[mid];

                else if (nums[low] <= nums[mid])
                    low = mid + 1;

                else if (nums[mid] <= nums[high])
                    high = mid - 1;

            }

            return -1;
        }
    }
