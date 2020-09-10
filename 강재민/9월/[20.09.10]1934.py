import sys
input=sys.stdin.readline

c = int(input())
for i in range( c ):
    a, b = map(int, input().split())
    ta , tb = a, b
    while(b!=0):
        tmp = a % b
        a = b
        b = tmp
    print( a * ta // a * tb // a )