#include <iostream>
#include <string>

using namespace std;

std::string uncensor(std::string str, std::string vowels)
{
	//string ans = str;
    for (int i = 0; i < vowels.length(); i++)
    {
        for (int j = 0; j < str.length(); j++)
        {
            if (str[j] == '*')
            {
                str[j] = vowels[i];
                j = str.length();
            }
        }
    }
    return str;
}


int main()
{
    string ans = uncensor("abcd", "");
    cout << ans << endl;
    return 0;
}