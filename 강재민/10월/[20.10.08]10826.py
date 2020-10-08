import sys
input=sys.stdin.readline

N = int(input())
a = 0
b = 1
c = 1

for i in range(2, N):
    a = b
    b = c
    c = b + a
if( N == 0  ):
    print( 0 )
else:
    print( c )