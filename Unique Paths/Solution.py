# %%
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        row = [1] * n
        for i in range(m - 1):
            newRow = [1] * n
            for j in range(n-2, -1, -1):
                newRow[j] = newRow[j + 1] + row[j]
            row = newRow
        return row[0]
        

sol = Solution()
print(sol.uniquePaths(3,7))
print(sol.uniquePaths(3,2))
print(sol.uniquePaths(1,1))
print(sol.uniquePaths(5,100))

# %%



