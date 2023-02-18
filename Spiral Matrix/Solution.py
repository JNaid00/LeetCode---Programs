# %%
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        total = len(matrix) * len(matrix[0])
        count = 0
        i, j = 0, 0
        ans = []
        rightLength = len(matrix[0])
        downHeight = len(matrix) - 1
        leftLength = len(matrix[0]) - 1
        upHeight = len(matrix) - 2
        while count < total:
            # Go to the right
            for k in range(rightLength):
                ans.append(matrix[i][j])
                count += 1
                if k + 1 != rightLength:
                    j += 1
            if count == total:
                return ans
            i += 1
            # Go to the down
            for k in range(downHeight):
                ans.append(matrix[i][j])
                count += 1
                if k + 1 != downHeight:
                    i += 1

            j -= 1
            if count == total:
                return ans
            # Go to the Left
            for k in range(leftLength):
                ans.append(matrix[i][j])
                count += 1
                if k + 1 != leftLength:
                    j -= 1
            i -= 1
            if count == total:
                return ans
            # Go to the Up
            
            for k in range(upHeight):
                ans.append(matrix[i][j])
                count += 1
                if k + 1 != upHeight:
                    i -= 1
            j += 1
            rightLength -= 2
            downHeight -= 2
            leftLength -= 2
            upHeight -= 2
        return ans


sol = Solution()
print(sol.spiralOrder([[1, 2]]))
print(sol.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
print(sol.spiralOrder([[1, 2, 3, 4], 
                        [5, 6, 7, 8], 
                        [9, 10, 11, 12], 
                        [13, 14, 15, 16]]))
print(sol.spiralOrder([ [1, 2, 3, 4, 13], 
                        [5, 6, 7, 8, 14],
                        [9, 10, 11, 12, 15], 
                        [16, 17, 18, 19, 20]]))
print(sol.spiralOrder([ [1, 2, 3, 4, 13], 
                        [5, 6, 7, 8, 14],
                        [9, 10, 11, 12, 15], 
                        [16, 17, 18, 19, 20],
                        [16, 17, 18, 19, 20]]))


# %%



