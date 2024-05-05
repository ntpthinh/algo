# Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
from typing import List


class Solution:
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()
        for k in range(n):
            # find the number of (i,j) pait in range [k+1,n-1] that satisfy nums[i] + nums[j] < target - nums[k]
            i, j = k+1, n-1
            while i < j:
                if nums[i] + nums[j] < target - nums[k]:
                    count += j-i
                    i += 1
                else:
                    j -= 1

        return count
    
    # Time complexity: O(n^2)
    # Space complexity: O(sorting space)
    # - Python, Java: TimSort = MergeSort + InsertionSort, O(n) space
    # - C++: IntroSort = QuickSort + HeapSort, O(logn) space
    # - C: QuickSort, O(logn) space
    # - JavaScript: QuickSort, O(logn) space
    # - Swift: QuickSort, O(logn) space
    # - Go: QuickSort, O(logn) space
    # - Rust: QuickSort, O(logn) space
    # - Kotlin: QuickSort, O(logn) space
    # - Scala: QuickSort, O(logn) space
    # - Ruby: QuickSort, O(logn) space
    # - PHP: QuickSort, O(logn) space
    # - TypeScript: QuickSort, O(logn) space
    # - C#: QuickSort, O(logn) space
    # - Swift: QuickSort, O(logn) space
    # - Java: QuickSort, O(logn) space
