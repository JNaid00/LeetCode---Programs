# %%
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = [[]]
        for i in nums:
            ans += [[i] + list for list in ans]
        return ans
sol = Solution()
print(sol.subsets([0]))
print(sol.subsets([0,2]))
print(sol.subsets([1,2,3]))
print(sol.subsets([1,2,3,4]))

# %%



