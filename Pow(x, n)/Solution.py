# %%
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        isNegative = True if n < 0 else False
        n = abs(n)
        ans = x
        for i in range(1, n):
            ans *= x
        
        return ans if isNegative == False else 1/ans

sol = Solution()
print(sol.myPow(2,10))
print(sol.myPow(2.10000,3))
print(sol.myPow(2,-2))
print(sol.myPow(156,-2))


