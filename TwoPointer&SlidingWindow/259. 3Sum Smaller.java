class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            int remainder = target - nums[i];
            while(left < right){
                if(nums[left] + nums[right] < remainder){
                    count+=right-left;
                    left++;
                }
                else
                    right--;
            }
        }
        return count;
    }
}