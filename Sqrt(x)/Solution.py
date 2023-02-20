# %%
class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x== 1 or x== 0: return x
        prev = 1
        for i in range(1,x):
            squared = i * i
            if squared > x: return prev
            else:
                prev = i
        
        return prev


sol = Solution()
print(sol.mySqrt(2))
print(sol.mySqrt(4))
print(sol.mySqrt(8))
print(sol.mySqrt(10))
print(sol.mySqrt(16))
print(sol.mySqrt(123456898))
print(sol.mySqrt(95))


