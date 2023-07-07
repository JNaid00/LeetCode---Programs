# %%
import math


class Solution(object):
    def isValidSudoku(self, board: list):
        """
        :type board: int[][]
        :rtype: bool
        """
        row = []
        col = []
        box = []
        for i in range(9):
            row.append([])
            col.append([])
            box.append([])
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] != '.':
                    boxno = 3*math.floor(i/3) + math.floor(j/3)
                    if row[i].count(board[i][j]) != 0 or col[j].count(board[i][j]) != 0 or box[boxno].count(board[i][j]) != 0:
                        return False

                    row[i].append(board[i][j])
                    col[j].append(board[i][j])
                    box[boxno].append(board[i][j])

        return True


sol = Solution()
arr =       [['5', '3', '.', '.', '7', '.', '.', '.', '.'],
             ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
             ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
             ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
             ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
             ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
             ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
             ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
             ['.', '.', '.', '.', '8', '.', '.', '7', '9']]
print(sol.isValidSudoku(arr))
arr =      [['8','3','.','.','7','.','.','.','.']
,['6','.','.','1','9','5','.','.','.']
,['.','9','8','.','.','.','.','6','.']
,['8','.','.','.','6','.','.','.','3']
,['4','.','.','8','.','3','.','.','1']
,['7','.','.','.','2','.','.','.','6']
,['.','6','.','.','.','.','2','8','.']
,['.','.','.','4','1','9','.','.','5']
,['.','.','.','.','8','.','.','7','9']]
print(sol.isValidSudoku(arr))

