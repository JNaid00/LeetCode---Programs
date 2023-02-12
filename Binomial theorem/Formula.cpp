#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int choose(int n,int  k)
{
    if (k == 0) return 1;
    return (n * choose(n - 1, k - 1)) / k;
}

std::string Formula(int n)
{
	string ans = "";
    int negativeN = n;
    if(negativeN < 0)
    {
        n *= -1;
        ans = "1/(";
    }
    for (int k = 0; k <= n; k++)
    {
        //ans += to_string(coefficient(n,k)) + "a^" + to_string(n-k) + "b^"  + to_string(k) + "+";
        if (choose(n,k) != 1)
        ans += to_string(choose(n,k));

        if (n-k == 1)
        ans  +=  "a";
        else 
        if (n-k == 0)
        {
        }
        else
        {
            ans  +=  "a^";
            ans += to_string(n-k);
        }


        if (k == 1)
        ans  +=  "b";
        else
        if (k == 0){}
        else
        {
            ans  +=  "b^";
            ans += to_string(k);
        }
        if (k != n)
        ans += "+";
    }
    
    if (negativeN < 0){ans += ")";}
    
    return ans;
}

int main()
{
  // cout <<choose(27,4) << endl;
   cout << Formula(-1) << endl;
    return 0;
}