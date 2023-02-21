# %%
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            if nums[i] == 0:
                temp = nums.pop(i)
                nums.insert(0, temp)
            elif nums[i] == 2:
                temp = nums.pop(i)
                nums.insert(len(nums), temp)
        

sol = Solution()
arr = [2,0,2,1,1,0]
sol.sortColors(arr)
print(arr)
arr = [2,0,1]
sol.sortColors(arr)
print(arr)
arr = [2,0,2,1,1,0,0,0,0,0,0,]
sol.sortColors(arr)
print(arr)


