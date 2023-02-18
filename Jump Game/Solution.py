# %%
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        max = len(nums) - 1
        index = 0
        for i in range(len(nums)):
            curr = nums[i]
            index= i + curr
            while(index < max):
                curr = nums[index]
                if curr == 0: break
                index += curr
            if index == max:
                return True
        return False

sol = Solution()
print(sol.canJump([2,3,1,1,4]))
print(sol.canJump([3,2,1,0,4]))
print(sol.canJump([3,2,1,2,0,4]))
print(sol.canJump([2,3,1,1,4,0,0,0,0]))
print(sol.canJump([2,3,1,1,4,0,0,1]))
print(sol.canJump([5,2,1,2,0,4]))


