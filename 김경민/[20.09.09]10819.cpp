#include <iostream>
#include <cmath>
#include <vector>
#include <array>

using namespace std;

static int pmax = -100000;
bool isUsed[10];
int arr_size;
vector<int> a;
void calculate(vector<int> arr)
{
    int sum = 0;
    for(int i=0;i<arr.size() - 1;i++)
    {
        sum += abs(arr[i] - arr[i+1]);
    }
    if(pmax < sum)
    {
        pmax = sum;
    }
}

void track(int arr[], int N)
{
    if(N == 0)
    {
        calculate(a);
    }
    else
    {
        for(int i=0;i<arr_size;i++)
        {
            if(!isUsed[i])
            {
                isUsed[i] = true;
                a.push_back(arr[i]);
                track(arr, N - 1);
                a.pop_back();
                isUsed[i] = false;
            }
        }
    }
}

int main(){
    cin >> arr_size;
    int arr[arr_size];
    for(int i=0;i<arr_size;i++)
    {
        cin >> arr[i];
    }
    track(arr, arr_size);
    cout << pmax;
}
