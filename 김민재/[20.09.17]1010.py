from itertools import combinations

def mCn(m, n):
    n = min(n, m-n)
    denominator = 1
    numerator = 1
    
    for i in range(1, n+1):
        denominator *= i
        numerator *= m + 1 - i

    return int(numerator/denominator)


T = int(input())

for i in range(T):
    N, M = map(int, input().split())
    print(mCn(M, N))
