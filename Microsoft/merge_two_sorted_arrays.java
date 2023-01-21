public class merge_two_sorted_arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // time complexity : O(n+m) , space complexity : O(n+m)
        // brute force approach
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                k++;
                i++;

            } else {
                nums3[k] = nums2[j];
                k++;
                j++;

            }

        }

        while (i < nums1.length) {
            nums3[k] = nums1[i];
            k++;
            i++;
        }

        while (j < nums2.length) {
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        if (nums3.length % 2 != 0)
            return (double) nums3[nums3.length / 2];

        return (double) (nums3[(nums3.length - 1) / 2] + nums3[nums3.length / 2]) / 2.0;
    }
}
