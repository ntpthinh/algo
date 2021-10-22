class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // map remainder, frequency

        /**
         * general idea: use map to store all remainders and its frequency of the sum of
         * elements up to current index. If the remainder already existed in the map, it
         * means that the sum is divided 
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