class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start])
                end = mid;
            else
                start = mid + 1;
        }
        return nums[start];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] <= nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}