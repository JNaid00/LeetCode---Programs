# %%
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        goal = len(nums) - 1
        for i in range(len(nums) - 1,-1, -1):
            numsI = nums[i]
            if i + nums[i] >= goal:
                goal = i
        if goal == 0: return True
        return False

sol = Solution()
print(sol.canJump([2,3,1,1,4]))
print(sol.canJump([3,2,1,0,4]))
print(sol.canJump([3,2,1,2,0,4]))
print(sol.canJump([2,3,1,1,4,0,0,0,0]))
print(sol.canJump([2,3,1,1,4,0,0,1]))
print(sol.canJump([5,2,1,2,0,4]))

