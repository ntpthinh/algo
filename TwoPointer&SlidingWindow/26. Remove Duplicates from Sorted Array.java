class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=1) return n;
        int i = 1;
        int count = 1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]){
                nums[count]=nums[i];
                count++;
            }
            i++;
        }
        return count;
    }
}