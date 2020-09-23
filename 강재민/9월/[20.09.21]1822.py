import sys
input=sys.stdin.readline

N, M = map(int, input().split() )
A = set(map(int, input().split()) )
B = set(map(int, input().split()) )
if( len( A - B ) == 0 ):
    print( 0 )
else:
    print( len( A - B ) )
    for i in sorted( A - B ):
        print( i , end = " " )