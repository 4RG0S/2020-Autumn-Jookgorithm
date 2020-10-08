import re

t = int(input())

for tc in range(t):
    input()
    n, m = map(int, input().split())
    sejun = list(map(int, input().split()))
    sebi = list(map(int, input().split()))

    sejun.sort()
    sebi.sort()

    while len(sejun) > 0 and len(sebi) > 0:
        if sejun[0] < sebi[0]:
            sejun.pop(0)
        else:
            sebi.pop(0)

    if len(sejun) == 0:
        print('B')
    else:
        print('S')