class Solution {
    // to solve this problem, I might refer to the problem that find the k smallest
    // element in an unsorted array, which uses quickselect to solve. Finding
    // k-largest
    // elements means that we need to find n-k smallest element.
    // The quickselect algorithm is as followed. Get the pivotIndex, if it equals to
    // k, that the number we need to find.
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return select(nums, 0, n - 1, n - k);
    }

    public int select(int[] nums, int low, int high, int k) {
        int pivotIndex = partition(nums, low, high);
        if (pivotIndex == k)
            return nums[pivotIndex];
        if (pivotIndex > k) {
            return select(nums, low, pivotIndex - 1, k);
        }
        return select(nums, pivotIndex + 1, high, k);
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int boundary = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, boundary);
                boundary++;
            }
        }
        swap(nums, high, boundary);
        return boundary;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}