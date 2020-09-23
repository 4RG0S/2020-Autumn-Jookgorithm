import sys
input=sys.stdin.readline

N = int(input())
i = 1
while(True):
    if( i == N ):
        break
    i += 1
    if( N % i == 0 ):
        print( i )
        N = N / i
        i = 1
    