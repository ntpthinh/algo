class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap();
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum12 = nums1[i] + nums2[j];
                map.put(sum12, map.getOrDefault(sum12, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum34 = nums3[i] + nums4[j];
                if (map.containsKey(-sum34))
                    count += map.get(-sum34);
            }
        }
        return count;
    }
}