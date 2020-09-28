N, K = map(int, input().split())

N -= (K * (K + 1)) / 2
if N < 0:
    print(-1)
else:
    if N % K == 0:
        print(K - 1)
    else:
        print(K)
