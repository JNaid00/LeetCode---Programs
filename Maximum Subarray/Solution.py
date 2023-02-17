class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1: return nums[0]
        ans = nums[0]
        
        for i in range(len(nums)):
            test = nums[i]
            if test > ans: ans = test
            for j in range(i + 1, len(nums)):
                test += nums[j]
                if test > ans: ans = test

        return ans

sol = Solution()
print(sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
print(sol.maxSubArray([5,4,-1,7,8]))
print(sol.maxSubArray([5,-23,4,-1,7,8,2]))
print(sol.maxSubArray([1]))




