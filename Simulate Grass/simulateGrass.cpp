#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

using std::vector;
using std::string;


vector<string> simulateGrass(vector<string> g, int x, int y)
{
    if (g[x][y] == '.')
    {
        g[x][y] = '+';
        g = simulateGrass(g,x-1,y);
        g = simulateGrass(g,x+1,y);
        g = simulateGrass(g,x,y-1);
        g = simulateGrass(g,x,y+1);
    }
    return g;
}

int main()
{
    std::vector<std::string> vec({"xxxxxxx","x.....x","xxxx..x","x...xxx","xxxxxxx"});
    //cout << vec[2][3] << endl;
    std::vector<std::string> vecN = simulateGrass(vec, 1, 1);
    for (long long unsigned int i = 0; i < vecN.size(); i++)
    {
        cout << vecN[i] << endl;
    }
    
    return 0;
}


