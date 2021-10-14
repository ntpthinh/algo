class Solution {
    public int maxSubArraySum(int[] arr, int k) {
        if (arr.length == 0)
            return 0;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int count = 0;

        // problem transform to find
        Set<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (prefix[i] == k)
                count++;
            if (set.contains(prefix[i]))
                count++;
            else {
                set.add(prefix[i] + k);
            }
        }
        return count;
    }
}