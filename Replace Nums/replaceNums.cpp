#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <cmath>
#include<string>

using namespace std;

string convertBinary(int value)
{
    string r;
    while(value!=0) {r=(value%2==0 ?"0":"1")+r; value/=2;}
    return r;
}

std::string replaceNums(std::string str)
{
    string numbers = "0123456789", binary, strCopy = str;
    int lastpos = 0, value = 0;
	for (int i = 0; i < str.length(); i++)
    {
        lastpos = i;
        if (numbers.find(str[i]) != std::string::npos)
        {
           while ((numbers.find(str[lastpos + 1]) != std::string::npos))
           {
            lastpos += 1;
           }
            value =  stoi(str.substr(i, lastpos - i + 1));
            binary = convertBinary(value);
            str.erase(i, lastpos - i + 1);
            str.insert(i,binary);
            i =  i + binary.length();
        }
    }
    
    return str;
}



int main()
{
    cout << replaceNums("I want to thot ehonsv 809 joew9 9") << endl;
    return 0;
    
}