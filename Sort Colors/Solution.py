# %%
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        start, end = 0, len(nums)-1
        curr = 0

        while curr <= end:
            if nums[curr] == 2:
                temp = nums[curr]
                nums[curr] = nums[end]
                nums[end] = temp
                end -= 1
            elif nums[curr] == 0:
                temp = nums[curr]
                nums[curr] = nums[start]
                nums[start] = temp
                start += 1
                curr += 1
            else:#if 1
                curr += 1
                
        

sol = Solution()
arr = [2,0,2,1,1,0]
sol.sortColors(arr)
print(arr)
arr = [2,0,1]
sol.sortColors(arr)
print(arr)
arr = [2,0,2,1,1,0,0,0,0,0,0]
sol.sortColors(arr)
print(arr)


