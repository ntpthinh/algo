class Solution {
    public void sortColors(int[] nums) {
        int boundary = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, boundary);
                boundary++;
            }

        }
        boundary = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, i, boundary);
                boundary--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}