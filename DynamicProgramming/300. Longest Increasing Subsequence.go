func lengthOfLIS(nums []int) int {
	// f[i] : length of the longest increasing subsequence
	n := len(nums)
	f := make([]int, n)
	f[0] = 1
	for i := 1; i < n; i++ {
		f[i] = 1
		for j := 0; j < i; j++ {
				if nums[i] > nums[j] {
						if f[i] < f[j] + 1 {
								f[i] =  f[j] + 1
						}
				}
		}
	}
	res := f[0]
	for i := 0; i < n; i++ {
			if res < f[i] {
					res = f[i]
			}
	}
	return res
}