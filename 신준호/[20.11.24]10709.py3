def getDist(clouds, r, c):
    dist = 0
    ptr = c
    while ptr >= 0:
        if clouds[r][ptr] == 'c':
            break
        ptr -= 1

    return c - ptr if ptr >= 0 else -1

h, w = list(map(int, input().split()))

clouds = list()
minMap = list()

for idx1 in range(h):
    clouds.append(list())
    minMap.append(list())

    s = input()
    for idx2 in range(w):
        clouds[idx1].append(s[idx2])
        minMap[idx1].append(0)

for r in range(h):
    for c in range(w):
        minMap[r][c] = getDist(clouds, r, c)

for r in range(h):
    print(' '.join(list(map(str, minMap[r]))))