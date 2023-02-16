# %%
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        #Base Case
        if len(nums) == 1:
            return [nums.copy()]
        for i in range(len(nums)):
            temp = nums.pop(0)
            perms = self.permute(nums)
            for p in perms:
                p.append(temp)
            ans.extend(perms)
            nums.append(temp)
        return ans

        
        
    
    def recursive(self, ans, nums):
        print(nums)



sol = Solution()
print(sol.permute([1,2,3]))
print(sol.permute([0,1]))
print(sol.permute([1]))


