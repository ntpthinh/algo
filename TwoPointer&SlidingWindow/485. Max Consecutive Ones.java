class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        // int current_max = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i]==1)
        //         current_max+=1;
        //     else current_max = 0;
        //     max= Math.max(current_max, max);
        // }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==1){
                int j = i;
                while(j < nums.length && nums[j] == 1) j++;
                max = Math.max(j-i,max);
                i=j;
            }
        }
        return max;
    }
}