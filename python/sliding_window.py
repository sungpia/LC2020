from typing import List
from queue import PriorityQueue
class Solution:

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # [1,3,-1,-3,5,3,6,7]
        # sliding window size of k, e.g.) k=3 [1, 3, -1] -> 3

        pq = PriorityQueue(reversed=True)
        for x in range(k):
            pq.put(x)

        ret = list()
        list.pu


        for idx in range(k, len(nums)):
            

s = Solution()
inp = [1,3,-1,-3,5,3,6,7]
ans = s.maxSlidingWindow(inp, 3)
print(ans)

