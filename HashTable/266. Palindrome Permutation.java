class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int oddCount = 0;
        for (Character i : map.keySet()) {
            if (map.get(i) % 2 == 1)
                oddCount += 1;
            if (oddCount > 1)
                return false;
        }
        return true;
    }
}