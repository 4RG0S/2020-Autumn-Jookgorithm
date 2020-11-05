from sys import stdin

N, M = map(int, stdin.readline().split())
cnt = 0
if N < 3:
    print(cnt)
else:
    dissonance = {i: [] for i in range(1, N + 1)}
    for _ in range(M):
        i, j = map(int, stdin.readline().split())
        dissonance[i].append(j)
        dissonance[j].append(i)

    for i in range(1, N+1):
        for j in range(i+1, N+1):
            if j in dissonance[i]:
                continue
            for k in range(j+1, N+1):
                if k in dissonance[i] or k in dissonance[j]:
                    continue
                cnt += 1
    print(cnt)
