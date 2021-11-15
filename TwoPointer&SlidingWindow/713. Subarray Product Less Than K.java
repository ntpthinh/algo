class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0;
        int count = 0;
        int curProduct = 1;
        
        while(end < nums.length){
            curProduct *= nums[end];
            while(curProduct >= k && start<=end){
                curProduct = curProduct / nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}