import sys
input=sys.stdin.readline

N = int(input())
S = [0, 0, 1, 1]
op = 0
for i in range( 4, N + 1 ):
    if( i % 3 == 0 and i % 2 == 0 ):
        S.append(  min( S[ i//3 ] , S[ i-1 ], S[ i//2] ) + 1)
    elif( i % 3 == 0 ):
        S.append(  min( S[ i//3 ] , S[ i-1 ] ) + 1 )
    elif( i % 2 == 0 ):
        S.append(  min( S[ i//2 ], S[ i-1] ) + 1)
    else:
        S.append( S[i-1] + 1 )
print( S[N] )