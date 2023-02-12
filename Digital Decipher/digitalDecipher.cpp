#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <cmath>

using namespace std;

std::string digitalDecipher(std::vector<int> eMessage, int key)
{
	string alphabet = "abcdefghijklmnopqrstuvwxyz";
    string ans;
    vector<int>::iterator it = eMessage.begin();
    int number = pow(10,to_string(key).length()-1);
    for (int i = 0; i < eMessage.size(); i++)
    {
        int digit = (key / number ) % 10 ;
        ans += alphabet[*(it) - digit - 1];
        ++it;
        
        if (number == 1)
          number = pow(10,to_string(key).length() - 1);  
        else
            number = number / 10;
    }
    return ans;
}

int main()
{
   // int eMessage[5] = {20, 12, 18, 30, 21};
    int key = 100;
    vector<int> eMessage{6, 4, 1, 3, 9, 20};
    string ans =  digitalDecipher(eMessage,key);
    cout << ans << endl;
    return 0;
}