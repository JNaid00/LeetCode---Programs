# %%
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        

        first, last = -1, -1
        if len(nums) == 0:
            return [first, last]
        left, right = 0, len(nums) - 1
        leftFound, rightFound = False, False
        while left <= right:
            if nums[left] == target and leftFound == False:
                first = left
                leftFound = True
            if nums[right] == target and rightFound == False:
                last = right
                rightFound = True
            if leftFound == True and nums[left] != target:
                return [first, left - 1]
            if rightFound == True and nums[right] != target:
                return [right + 1, last]

            left += 1
            right -= 1
        if nums[left] == target and leftFound == False:
                first = left
                leftFound = True
        if nums[right] == target and rightFound == False:
            last = right
            rightFound = True   
        if leftFound == True and nums[left] != target:
            return [first, left - 1]
        if rightFound == True and nums[right] != target:
            return [right + 1, last]
        return [first, last]

sol = Solution()
print(sol.searchRange([5,7,7,8,8,10], 8))
print(sol.searchRange([5,7,7,8,8,10], 6))
print(sol.searchRange([], 6))
print(sol.searchRange([5,7,7,8,8,10], 5))
print(sol.searchRange([5,7,7,8,8,10], 10))
print(sol.searchRange([1,1,1,1,1,1,5,7,7,8,8,10], 1))


