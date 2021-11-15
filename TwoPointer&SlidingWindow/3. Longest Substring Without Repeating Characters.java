class Solution {
    public int lengthOfLongestSubstring(String input) {
          if(input.length() <= 1) return input.length();
            int i = 0, j = 0;
            int res = 0;
            Set<Character> set = new HashSet<>();
            while(i < input.length()){
            if(!set.contains(input.charAt(i))){
                set.add(input.charAt(i));
                res = Math.max(res, set.size());
                i++;
            }
            else{
            set.remove(input.charAt(j));
            j++;
            }

            }
            return res;
    }
}