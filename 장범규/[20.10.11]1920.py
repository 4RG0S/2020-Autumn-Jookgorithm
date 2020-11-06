import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))

n_list.sort()
for i in m_list :
    search = 0
    l,r = 0,len(n_list)-1
    while (l <= r) :
        mid = (l+r)//2
        if (i == n_list[mid]) :
            print(1)
            search = 1
            break
        elif (i > n_list[mid]) :
            l = mid+1
        else :
            r = mid-1
    if (search == 0) :
        print(0)