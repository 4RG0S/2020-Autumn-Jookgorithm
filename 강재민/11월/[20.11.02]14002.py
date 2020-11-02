import sys
import copy
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
S = [0] * N
SL = list()
for i in range(N):
    SL.append([])
for idx, item in enumerate(A):

    minnum = 0
    count = 0
    temp = S.index(max(S))
    for j in range(0, idx):
        if(item > A[j]):
            if(minnum < S[j]):
                minnum = S[j]
                SL[idx] = copy.deepcopy(SL[j])
    SL[idx].append( item )
    S[idx] = minnum + 1
   
print(max(S))
for i in SL[S.index(max(S))]:
    print(i, end=' ')
