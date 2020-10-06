import sys
input=sys.stdin.readline

N = int(input())
A = list( map( int , input().split() ))
S = [ 0 ] * N
for idx, item in enumerate(A):
    minnum = 0
    for j in range( 0, idx ):
        if( item > A[j] ):
            if( minnum < S[j] ):
                minnum = S[j]
    S[idx] = minnum + 1
print( max(S) )

            
