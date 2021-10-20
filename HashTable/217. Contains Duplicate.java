class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i : nums){
        // if(map.get(i)==null)
        // map.put(i,1);
        // else
        // return true;
        // }
        // return false;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}