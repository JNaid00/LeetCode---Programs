# %%
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        col = len(matrix) - 1
        
        ans  = [ [0]*len(matrix) for i in range(len(matrix))]
        for i in range(len(matrix)):
            row = 0
            for j in range(len(matrix)):
                ans[row][col] = matrix[i][j]
                
                row += 1
            col -= 1
        for i in range(len(matrix)):
            row = 0
            for j in range(len(matrix)):
                matrix[i][j] = ans[i][j]



sol = Solution()
m = [[1,2,3],[4,5,6],[7,8,9]]
sol.rotate(m)
print(m)
m2 = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
sol.rotate(m2)
print(m2)


