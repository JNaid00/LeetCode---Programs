# %%
class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if dividend == -2147483648 and divisor == -1: return 2147483647
        negative = False
        if divisor < 0 or dividend < 0:
            negative = True
        if divisor < 0 and dividend < 0:
            negative = False

        dividend = abs(dividend)
        divisor = abs(divisor)
        count = 0
        temp = divisor
        
        
        if divisor > dividend:
            return 0
        
        while temp <= dividend:
            count += 1
            temp += divisor

        if negative == True:
            count *= -1
        return count
        

sol = Solution()
print(sol.divide(10,3))
print(sol.divide(120,6))
print(sol.divide(-6,-6))
print(sol.divide(7,-6))
print(sol.divide(7,-3))
    


