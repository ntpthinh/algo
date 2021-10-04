class Solution {
    public void moveZeroes(int[] nums) {
        // int i = 0;
        // for(int num: nums){
        // if(num!=0){
        // nums[i++] = num;
        // }
        // }
        // for(;i<nums.length;i++){
        // nums[i] = 0;
        // }

        int boundary = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, boundary);
                boundary++;
            }

        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}