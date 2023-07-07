# %%
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        min = 0
        left, right = 0, 0
        while right < len(nums) -1:
            farthest = 0
            for i in range(left, right + 1):
                farthest = max(farthest, i+ nums[i])
            left = right + 1
            right = farthest
            min += 1
            

        return min
            

sol = Solution()
print(sol.canJump([2,3,1,1,4]))
print(sol.canJump([3,2,1,2,0,4]))
print(sol.canJump([2,3,1,1,4,0,0,0,0]))
print(sol.canJump([2,3,1,1,4,0,0,1]))
print(sol.canJump([5,2,1,2,0,4]))


