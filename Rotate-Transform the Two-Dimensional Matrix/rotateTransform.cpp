#include<iostream>
#include<vector>

using namespace std;

std::vector<std::vector<int>> rotateTransform(std::vector<std::vector<int>> arr, int num)
{

    if (num > 0)
    {
        for (int i = 0; i < num; i++)
        {
            
        }
        
    }
    else
    {

    }
    
    
}

int main()
{
    vector<std::vector<int>> vec = {
        {1, 4, 0, 0},
	    {2, 8, 0, 0},
	    {0, 0, 3, 5},
	    {0, 0, 7, 1}
    };

    vec = rotateTransform(vec,1);
    for (int i = 0; i < vec.size(); i++)
    {
       for (int j = 0; j < vec[0].size(); j++)
       {
           cout << vec[i][j] << " ";
       }
       cout << endl;
       
    }
    
    return 0;
}