class Solution {
    public boolean isHappy(int n) {
        int num = n;
        int sum = 0;
        Set<Integer> set = new HashSet();
        while (num != 1) {
            sum = 0;
            while (num != 0) {
                int temp = num % 10;
                sum += temp * temp;
                num = num / 10;
            }
            if (set.contains(sum))
                return false;
            set.add(sum);
            num = sum;
        }
        return true;
    }
}