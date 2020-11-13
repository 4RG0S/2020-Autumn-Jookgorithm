from collections import deque

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    lst = list(map(int, input().split()))
    q = deque()
    for i in range(n):
        q.append([lst[i], i])

    lst.sort(reverse=True)
    cnt = 0
    while True:
        p = q.popleft()
        if p[0] == lst[0]:
            lst.pop(0)
            cnt += 1
            if p[1] == m:
                print(cnt)
                break
        else:
            q.append(p)
