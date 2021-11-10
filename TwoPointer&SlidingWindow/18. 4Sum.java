class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i< n-3; i++){
            if(i == 0 || nums[i]!=nums[i-1]){
                for(int j = i+1; j < n-2; j++){
                    if(j == i + 1 || nums[j] != nums[j-1]){
                        int start = j + 1, end = n - 1;
                        int remain = target - nums[i] - nums[j];
                        while(start<end){
                            if(nums[start] + nums[end] == remain){
                                res.add(List.of(nums[i], nums[j], nums[start], nums[end]));
                                while(start<n-1&&nums[start]==nums[start+1])start++;
                                while(end>0&& nums[end]==nums[end-1])end--;
                                start++;
                                end--;
                            }
                            else if(nums[start] + nums[end] > remain){
                                end--;
                            }else start++;
                        }   
                    }
                         
                }
            }
            
        }
        return res;
    }
}