# %%
# %%
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        return [self.binSearch(nums, target, True), self.binSearch(nums, target, False)]
        

    def binSearch(self, nums, target, leftBias):
        l,r = 0, len(nums) -1
        i = -1
        while l <= r:
            mid = (l + r) //2 
            if target > nums[mid]:
                l = mid + 1
            elif target < nums[mid]:
                r = mid - 1
            else:
                i = mid
                if leftBias == True:
                    r = mid - 1
                else:
                    l = mid + 1
        return i

sol = Solution()
print(sol.searchRange([5,7,7,8,8,10], 8))
print(sol.searchRange([5,7,7,8,8,10], 6))
print(sol.searchRange([], 6))
print(sol.searchRange([5,7,7,8,8,10], 5))
print(sol.searchRange([5,7,7,8,8,10], 10))
print(sol.searchRange([1,1,1,1,1,1,5,7,7,8,8,10], 1))




# %%



