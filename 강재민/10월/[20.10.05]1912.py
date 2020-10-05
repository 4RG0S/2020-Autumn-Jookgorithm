import sys
input=sys.stdin.readline

N = int(input())
A = list( map( int , input().split() ))
S = list()
for idx, item in enumerate( A ):
    if( idx == 0 ):
        S.append( A[idx] )
    else:
        S.append(   max( S[idx-1] + A[idx], A[idx] ) )
print( max(S) )
