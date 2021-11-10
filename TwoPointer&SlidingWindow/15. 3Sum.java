class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        
        for(int i = 0; i < n; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int start = i+1;
                int end = n - 1;
                while(start<end){
                    int sum = nums[start] + nums[end];
                    if(sum == -nums[i]) {
                        res.add(List.of(nums[i], nums[start], nums[end]));
                        while(end-1>0 && nums[end-1]==nums[end])end--;
                        while(start+1<n-1 && nums[start+1]==nums[start]) start++;
                        end--;
                        start++;
                    }
                    else if(sum > -nums[i]){
                        end--;
                    } 
                    else{
                        start++;
                    } 
                }      
            }

        }
        return res;
    }
}