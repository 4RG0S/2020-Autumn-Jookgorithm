#include <iostream>

using namespace std;

int main()
{
    int cow[10] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    int N;
    cin >> N;
    int result = 0;
    for(int i=0;i<N;i++)
    {
        int num, location;
        cin >> num >> location;
        if(cow[num - 1] == 3)
        {
            cow[num - 1] = location;
        }
        else if(cow[num - 1] != location)
        {
            cow[num - 1] = location;
            result++;
        }
    }
    cout << result;
}
