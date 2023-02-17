# %%
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        l, r = 0, len(matrix) - 1
        while l < r:
            for i in range(l, r):
                t, b = l, r
                temp = matrix[t][l + i]
                matrix[t][l+ i] = matrix[b - i][l]
                matrix[b - i][l] = matrix[b][r - i]
                matrix[b][r - i] = matrix[t + i][r]
                matrix[t + i][r] = temp
                
            l += 1
            r -= 1
                
            



sol = Solution()
m = [[1,2,3],[4,5,6],[7,8,9]]
sol.rotate(m)
print(m)
m2 = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
sol.rotate(m2)
print(m2)


