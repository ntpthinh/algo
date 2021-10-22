class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexes = new HashMap();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder == 0 && i >= 1)
                return true;
            if (remainderIndexes.containsKey(remainder)) {
                if ((i - remainderIndexes.get(remainder)) > 1)
                    return true;
            } else
                remainderIndexes.put(remainder, i);
        }
        return false;

    }
}