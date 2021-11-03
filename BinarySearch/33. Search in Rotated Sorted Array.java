class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[low] <= arr[mid]) {
                // the first part is an increasing array so we need to check if target is in
                // increasing part, otherwise it will be on the other half
                if (arr[low] <= target && arr[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // the second part is an increasing array so we need to check if target is in
                // increasing part, otherwise it will be on the other half
                if (arr[high] >= target && arr[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}