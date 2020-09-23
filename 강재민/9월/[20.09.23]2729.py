import sys
input=sys.stdin.readline

N = int(input())

for i in range(N):
    a, b = input().split()
    ta = int( a,  2)
    tb = int( b,  2)
    print( bin(ta+tb)[2:] )

