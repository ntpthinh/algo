class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // map remainder, frequency

        /**
         * general idea: use map to store all remainders and its frequency of the sum of
         * elements up to current index. If the remainder already existed in the map, it
         * means that there is at least one sum that have the same remainder as the
         * current element. We might think of this as: sum1 = n*k + r1, sum2 = m*k + r2,
         * if r1 == r2, sum2 - sum1 = (m-n)*k => there is a subarray that sum is
         * divisible by k. To count total number of subarray, we need to keep the
         * frequency of that remainder prior to current element.
         * 
         * If remainder < 0, remainder += k
         */
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        int rem = 0;
        for (int i : nums) {
            sum += i;
            rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem))
                count += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}