import sys
input=sys.stdin.readline

def get_gcd( a , b ):
    ta , tb = a, b
    while(b!=0):
        tmp = a % b
        a = b
        b = tmp
    if( len(str(a)) > 9 ):
        print( str(a)[-9:])
    else:
        print( a )

M = int(input())
A = list(map(int, input().split()))
M = 1
for i in A:
    M *= i
N = int(input())
B = list(map(int, input().split()))
N = 1
for i in B:
    N *= i
get_gcd( M, N )