# %%
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pos, finalpos, temp = 0, 0, 0
        count = 1
        while pos < len(nums):
            while pos < len(nums) and nums[pos] == nums[finalpos]:
                pos += 1

            if pos < len(nums):
                finalpos += 1
                nums[finalpos] = nums[pos]
                count += 1
                pos += 1

        print(nums)
        return count

            


sol = Solution()
print(sol.removeDuplicates([1,1,2]))
print(sol.removeDuplicates([1,1,2,2,2]))
print(sol.removeDuplicates([1,1,2,2,3,3,3,3,3,3,8,9]))
print(sol.removeDuplicates([1,2,3,4,5,6,7,8,9]))
print(sol.removeDuplicates([0,0,1,1,1,2,2,3,3,4]))



