# %%
class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = 0
        

        for i in range(len(nums)):
            val = abs(nums[i])
            if 1 <= val <= len(nums):
                
                if nums[val - 1] > 0:
                    nums[val - 1] *= -1
                elif nums[val-1] == 0:
                    nums[val-1] = -1 * (len(nums) + 1)
        
        for i in range(1, len(nums) +1 ):
            if (nums[i - 1] >= 0):
                return i
        return len(nums) + 1

sol = Solution()
print(sol.firstMissingPositive([1, 2, 0]))
print(sol.firstMissingPositive([3,4,-1,1]))
print(sol.firstMissingPositive([7,8,9,11,12]))
print(sol.firstMissingPositive([1,2,3,4,5,6,7,8,9,11,12]))
print(sol.firstMissingPositive([1,7,8,9,11,12]))

# %%



