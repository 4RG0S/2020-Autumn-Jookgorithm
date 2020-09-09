import sys
input=sys.stdin.readline

def isPrime(n):
    if( n == 1 ):
        return False
    i = 2
    while( i*i <= n ):
        if( n % i == 0 ):
            return False
        i += 1
    return True

s = 0
l = list()
N = int(input())
M = int(input())
for i in range(N, M+1):
    if(isPrime(i)):
        s += i
        l.append( i )

if( l ):
    print( s )
    print( l[0] )
else:
    print( -1 )
