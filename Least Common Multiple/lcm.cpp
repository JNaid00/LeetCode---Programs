#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int lcm(std::vector<int> nums)
{
    
	bool found = false;
    int ans = nums[0], count = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] > ans)
        ans = nums[i];
    }
    while (found == false)
    {
        count = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if ((ans % nums[i]) == 0)
            count += 1;
        }
        if (count == nums.size())
        found = true;
        else
        ans++;
    }


    return ans;
    
}

int main()
{
    vector<int> vec{5, 7, 11, 35, 55, 77};
    cout << lcm(vec) << endl;
    //cout << abs(-5) << endl;
    return 0;
}