#include<iostream>
#include<vector>
#include<string>

using namespace std;
bool harshadCheck(int n)
{
    if (n <= 0)
    {return false;}
    
    int total = 0, tempN = n;
    bool ans;
    while (tempN!=0)
    {
        total += tempN % 10;
        tempN /= 10; 
    }

    if ((n % total) == 0)ans =  true;
    else ans = false;
    
    return ans;
}
std::vector<int> harshad(int n)
{
	vector<int> arr;
    int clusterLength = 0, bN = n, tN = n;
    bool bottom = true, top = true;
    if (harshadCheck(n) == false)
    {
        arr.push_back(0);
        arr.push_back(0);
        return arr;
    }
    else
    clusterLength += 1;
    
    while ((bottom && (bN-1) > 0) || top)
    {
       if (harshadCheck(bN-1) && bottom)
       {
           clusterLength +=1;
           bN -= 1;
       }
       else
       bottom = false;
       if (harshadCheck(tN+1) && top)
       {
           clusterLength +=1;
           tN += 1;
       }
       else
       top = false;

    }
    int position = n - bN + 1;
    arr.push_back(clusterLength);
    arr.push_back(position);

    return arr;
}

int main()
{
    //cout << harshadCheck(10) << endl;
    vector<int> vec = harshad(2584);
    cout << vec[0] << " " << vec[1] << endl;
    return 0;
}