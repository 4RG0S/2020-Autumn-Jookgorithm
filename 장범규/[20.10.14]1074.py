import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def chk_count(n,r,c,count) :
    if (n == 0) :
        return count

    if (2**(n-1) <= r) :
        if (2**(n-1) <= c) : 
            return chk_count(n-1,r-(2**(n-1)),c-(2**(n-1)),count+(2**((n-1)*2))*3)
        else :
            return chk_count(n-1,r-(2**(n-1)),c,count+(2**((n-1)*2))*2)
    else :
        if (2**(n-1) <= c) :
            return chk_count(n-1,r,c-(2**(n-1)),count+(2**((n-1)*2))*1)
        else :
            return chk_count(n-1,r,c,count)

n,r,c = map(int, input().split())
print(chk_count(n,r,c,0))