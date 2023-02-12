#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


string spaceAndDot(int x, int y)
{
    string ans = "";
    for (int i = 0; i < x; i++)
    ans += ".";
    ans += " ";
    for (int i = 0; i < y; i++)
    ans += ".";
    ans += " "; 

    return ans;
}

std::string tapCode(std::string text)
{
	vector<vector<char>> alpha =
    {
        {'a','b','c','d','e'},
        {'f','g','h','i','j'},
        {'l','m','n','o','p'},
        {'q','r','s','t','u'},
        {'v','w','x','y','z'}
    };
    string ans = "";
    size_t found = text.find_first_not_of(" .");
    if (found!=std::string::npos)
    {
        for (int k = 0; k < text.length(); k++)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    char alphabet = alpha[i][j];
                    if (text[k] == 'k')
                    {
                        ans += ". ... ";
                        i = 6;
                        j = 7;
                    }
                    else
                    if (text[k] == alpha[i][j])
                    {
                        ans += spaceAndDot(i + 1,j + 1);
                        i = 6;
                        j = 7;
                    }
                    
                }
                
            }
            
        }
        
       ans.erase(ans.length(), 1);
    }
    else
    {
         int x,y;
        size_t length = (count(text.begin(), text.end(), ' ') + 1)  / 2; 
        for (int i = 0; i < (length-1); i++)
        {
            x = text.substr(0,text.find(' ')).length() - 1;
            text.erase(0, text.find(' ') + 1);
            y = text.substr(0,text.find(' ')).length() - 1;
            text.erase(0, text.find(' ') + 1);
            ans += alpha[x][y];
        }
        x = text.substr(0,text.find(' ')).length() - 1;
        text.erase(0, text.find(' ') + 1);
        y = text.substr(0,text.find(' ')).length() - 1;
        ans += alpha[x][y];
    }


    return ans;
}

int main()
{
    cout << tapCode(". ..... ..... ... ... ..... .... .. . ..... .... ... .... ... .. .... ... .... ... ...") << endl;
    return 0;
}