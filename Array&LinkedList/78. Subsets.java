class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        double n = Math.pow(2, nums.length);
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList();
            for (int j = 0; j < nums.length; j++) {
                if (getBit(i, j) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    public int getBit(int num, int index) {
        return (num >> index) & 1;
    }
}