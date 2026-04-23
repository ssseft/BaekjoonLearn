#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int num,notation,remain;
    
    vector<char> vec;
    
    cin>>num>>notation;
    
    while(num>=notation){
        remain=num%notation;
        if(remain>=0 && remain<=9)vec.push_back(remain+'0');
        else vec.push_back((char)(remain+55));
        num/=notation;
              
    }
    if(num<notation){
        if(num>=0 && num<=9)vec.push_back(num+'0');
                
        else vec.push_back((char)(num+55));
            
            
        }
    
    for (int i = vec.size()-1; i >=0 ; i--) cout << vec[i];
    
    return 0;
}