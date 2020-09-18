import sys
input=sys.stdin.readline

N = int(input())
s = list()
for i in range(N):
    inp = int(input())
    if( inp == 0 ):
        s.pop()
    else:
        s.append( inp )
a = 0
for i in s:
    a+=i
print( a )