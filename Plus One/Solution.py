# %%
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        if length == 0 : return digits
        digits[length - 1] += 1

        for i in range(length - 1, -1, -1):
            if digits[i] >= 10:
                digits[i] = 0
                if i == 0:
                    digits = [1] + digits
                else:
                    digits[i - 1] += 1
            else:
                return digits

        return digits


sol = Solution()
print(sol.plusOne([1, 2, 9]))
print(sol.plusOne([1, 2, 4]))
print(sol.plusOne([4, 3, 2, 1]))
print(sol.plusOne([9]))
print(sol.plusOne([9, 9, 9, 9, 9, 9, 9]))
print(sol.plusOne([0]))


# %%



