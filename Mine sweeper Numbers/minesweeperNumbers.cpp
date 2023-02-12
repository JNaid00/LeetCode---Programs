#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
bool range(int x, int y, int lengthX, int widthY)
{
    if (x >= 0 && y >= 0 && x < lengthX && y < widthY)
    return true;
    else
    return false;
}
std::vector<std::vector<int>> minesweeperNumbers(std::vector<std::vector<int>> board)
{
    int count;
    for (int i = 0; i < board.size(); i++)
    {
        count = 0;
        for (int j = 0; j < board[i].size(); j++)
        {
            count = 0;
            if (board[i][j] == 1)
            board[i][j] = 9;
            else
            {

                for (int row = -1; row <=1 ;row++)
                {
                    for (int col = -1; col <= 1; col++)
                    {
                      if (range(i + row, j + col, board.size(), board[i].size()))
                      {
                          if (board[row + i][col + j] == 9 || board[row + i][col + j] == 1)
                          count +=1;
                      }
                    }
                    
                }
                if (count != 1)
                board[i][j] = count;
                else
                board[i][j] = 10;
                
            }
        }
        
    }

    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[i].size(); j++)
        {
           if (board[i][j] == 10)
           board[i][j] = 1;
        }   
    }
    return board;
}



int main()
{
    std::vector<std::vector<int>> vec
    {
        {0, 0, 0, 1},
        {0, 1, 0, 0},
        {1, 0, 0, 0},
        {0, 0, 1, 0}  
    };
    //cout << vec[2][2] << endl;
    // if (vec[5][5] == 1)
    // cout << "true" << endl;
    // else
    // cout << "false" << endl;
   std::vector<std::vector<int>> vect = minesweeperNumbers(vec);
    for (int i = 0; i < vect.size(); i++)
    {
        for (int j = 0; j < vect[i].size(); j++)
        {
            cout << vect[i][j] << " ";
        }   
        cout << endl;
    }
    return 0;
}