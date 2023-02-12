#include<iostream>
#include<cmath>
#include<vector>
#include<numeric>
#include<stack>

using namespace std;

float series(vector<float> vec)
{
   // return accumulate(vec.begin(), vec.end(),0);
   float ans = 0;
   for (int i = 0; i < vec.size(); i++)
   {
       ans += vec[i];
   }

   return ans;
}

float parallel(vector<float> vec)
{
   // float ans = accumulate(vec.begin(), vec.end(),0);
   float ans = 0;
   for (int i = 0; i < vec.size(); i++)
   {
       ans += (1/vec[i]);
   }
   
    ans = 1 / ans;
    return ans;
}



float resist(std::string net)
{
	stack<string> ris;
    string num = "";
    for (int i = 0; i < net.length(); i++)
    {
        char c = net[i];
        if (c == '(' || c == '[')
        {
            string s(1,c);
            ris.push(s);            
        }
        else
        if (c >= '0'  && c <= '9')
        {
            num = c;
            int count  = 1 ;
            while (net[i + count] >= '0'  && net[i + count] <= '9')
            {
               num += net[i + count];
               count++;
            }
            ris.push(num);
            i += count - 1;
            num = "";
        }
        else
        if (c == ']' || c == ')')
        {
           vector<float> sum;
           while (ris.top() != "(" && ris.top() != "[")
            {
               sum.push_back(stof(ris.top()));
               ris.pop();
            }

            if (ris.size() > 0) {ris.pop();}
            
            if (c == ')')
            {
               ris.push(to_string(series(sum)));
            }
            else
            ris.push(to_string(parallel(sum)));
            
        }
        
    }
    
    float ans = stof(ris.top());
    ans = float(int(ans * 10 + 0.5)) / 10;
    //return round(10*ans)/10;
    return ans;
}


int main()
{
    cout << resist("[([(470, 1000), 330], 470), 680]") <<endl;
    return 0;
}
