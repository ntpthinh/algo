class Solution {
    // since nums1's length can contains nums2, we place the element as it should be
    // from the tail, which means that larger element of 2 arrays will be arranged
    // at the tail first. If length of nums2 > nums1, all remaining elements of
    // nums2 < first element of nums1 so they will be placed in the beginning of
    // nums1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}