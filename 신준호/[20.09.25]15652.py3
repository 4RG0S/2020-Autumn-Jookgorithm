def NandMs(N, M, li, prev):
    if len(li) == M:
        print(' '.join(li))
    else:
        for i in range(N):
            if i < prev:
                continue
            li.append(str(i + 1))
            NandMs(N, M, li, i)
            li.pop()

N, M = map(int, input().split())
NandMs(N, M, [], 0)