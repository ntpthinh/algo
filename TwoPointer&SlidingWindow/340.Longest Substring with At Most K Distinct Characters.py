from collections import Counter
import math


class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        l = 0
        counter = Counter()
        ans = 0
        for r, c in enumerate(s):
            counter[c] += 1
            while len(counter) > k:
                counter[s[l]] -= 1
                if counter[s[l]] == 0:
                    counter.pop(s[l])
                l += 1
            ans = math.max(ans, r-l+1)
        return ans
