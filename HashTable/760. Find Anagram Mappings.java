class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);

            // if(map.containsKey(nums2[i]))
            // {
            // // Stack temp = map.get(nums2[i]);
            // // temp.add(i);
            // //map.put(nums2[i], map.get(nums2[i]).add(i));
            // map.add(nums2[i], i);
            // }
            // else{
            // Stack<Integer> stack = new Stack();
            // stack.add(i);
            // map.put(nums2[i],stack);

            // }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}