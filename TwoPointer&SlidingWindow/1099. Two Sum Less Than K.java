class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        int max = -1;
        while(left<right){
            if(nums[left]+nums[right] < k){
                max = Math.max(nums[left]+nums[right], max);
                left++;
            }
            else right--;
        }
        return max;
    }
}