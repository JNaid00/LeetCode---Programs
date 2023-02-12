#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <cmath>
#include<string>

using namespace std;

std::string nicoCipher(std::string message, std::string key)
{
	string numbers = "abcdefghijklmnopqrstuvwxyz";
    string intKey = "";
    string newKey = key;
    sort(newKey.begin(), newKey.end());
    //cout << "newKey: " << newKey << endl;
    for (int i = 0; i < key.length();i++)
    {
        intKey += to_string(newKey.find(key[i]));
    }
   // cout << "intKey: " << intKey << endl;

    string **arrMessage;
    arrMessage = new string*[key.length()];

    int col = 0;
    col = message.length() / key.length();
    if ((message.length() % key.length()) != 0)
    col += 1;
    for (int i = 0; i < key.length(); i++)
    {
      arrMessage[i] = new string[col];
      for (int j = 0; j < col; j++)
      {
         arrMessage[i][j] = " ";
      }
      
    }
    for (int j = 0; j < (col-1); j++)
    {
        for (int i = 0; i < key.length(); i++)
        {
           arrMessage[i][j] = message[ (j*key.length()) + i];
        }
        
    }

    int lastCol;
    if ((message.length() % key.length()) != 0)
    lastCol = message.length() % key.length();
    else
    lastCol = key.length();

    for (int i = 0; i < lastCol; i++)
    {
        arrMessage[i][col-1] = message[ (col - 1) * key.length() + i];
    }

    //ascending order
    string *temp = nullptr;
   char charTemp;
    for(int i=0;i<key.length();i++)
	{		
        //cout << "intKey[i]: " << intKey[i] << endl;
		for(int j=i+1;j<key.length();j++)
		{
			if(intKey[i] > intKey[j])
			{
				temp  = arrMessage[i];
				arrMessage[i]=arrMessage[j];
				arrMessage[j]=temp;
                charTemp = intKey[i];
                intKey[i] =  intKey[j];
                intKey[j] = charTemp;
			}
		}
	}
    string ans = "";
    
    for (int i = 0 ; i < col;i++)
    {
        for (int j = 0 ; j <  key.length();j++)
        {
            ans += arrMessage[j][i];
        }
    }
    
    return ans;
    
}

int main()
{
    cout <<nicoCipher("iwillquitsoon", "endisnear") << endl;
    return 0;
}




    // if ((message.length() % key.length()) != 0)
    // {
    //     for (int i = 0; i < (message.length() % key.length());i++)
    //     {
    //         arrMessage[i][col-1] = message[ (col - 1) * key.length() + i];
    //     }
    // }
    // else
    // {
    //     for (int i = 0; i < key.length(); i++)
    //     {
    //        arrMessage[i][col-1] = message[ (col - 1) * key.length() + i];
    //     }
    // }