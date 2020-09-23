from collections import deque

n = int(input())
ballon = list(map(int, input().split()))
order = [i for i in range(1,n+1)]
bd = deque(ballon)
od = deque(order)

for i in range(n) :
    mv = bd.popleft()
    print(od.popleft(),end=" ")
    if (mv > 0) :
        bd.rotate(-(mv-1))
        od.rotate(-(mv-1))
    else :
        bd.rotate(-mv)
        od.rotate(-mv)
