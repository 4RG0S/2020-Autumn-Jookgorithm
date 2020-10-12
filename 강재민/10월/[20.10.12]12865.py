import sys
input=sys.stdin.readline

N, M = map( int, input().split() )
item = list()
for i in range(N):
    item.append( tuple(map( int, input().split())))

S = [[0 for col in range(M+1)] for row in range(N+1)]

for i in range( 1, N+1 ):
    for j in range( 1, M+1 ):
        if( j >= item[i-1][0] ):
            S[ i ][ j ] = max( S[ i-1 ][j],  S[i-1][(j - item[ i-1 ][ 0 ])] + item[i-1][1] )
        else:
            S[ i ][ j ] = S[i-1][j]

print( S[-1][-1] )
