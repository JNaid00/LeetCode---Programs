class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1: return nums[0]
        if len(nums) == 0: return 0
        
        sum_max = nums[0]
        sum_including_current = nums[0]

        for i in range(1,len(nums)):
            sum_including_current = max(sum_including_current + nums[i], nums[i])
            sum_max = max(sum_max, sum_including_current)

        return sum_max

sol = Solution()
print(sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
print(sol.maxSubArray([5,4,-1,7,8]))
print(sol.maxSubArray([5,-23,4,-1,7,8,2]))
print(sol.maxSubArray([1]))