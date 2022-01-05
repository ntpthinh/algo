func rob(nums []int) int {
	// f[i]: maximum amount of money till i
	n := len(nums)
	
	if n == 1{
			return nums[0]
	}
	if n == 2 {
			if nums[1] > nums[0] {
					return nums[1]
			}
			return nums[0]
	}
	
	f := make([]int, n)
	f[0] = nums[0]
	f[1] = max(nums[0], nums[1])
	for i := 2; i < n; i++ {
			f[i] = max(f[i-1], f[i-2] + nums[i])
	}
	return f[n-1]
//     f[1] = nums[1]
//     for i := 2; i < n; i++ {
//         for j := 0; j < i - 1; j++ {
//             if f[j] + nums[i] > f[i] {
//                 f[i] = f[j] + nums[i]
//             }
//         }
//     }
	// res := f[0]
	// for i:=0; i < n; i++ {
	//     if res < f[i]{
	//         res = f[i]
	//     }
	// }
	// return res
}
func max(x, y int) int{
	if x > y {
			return x
	}
	return y
}