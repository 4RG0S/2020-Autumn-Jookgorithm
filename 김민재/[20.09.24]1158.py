from sys import stdin

N, K = map(int, stdin.readline().split())
seat = [i for i in range(1, N+1)]
josephus = []

jo = 0
for _ in range(N):
    jo += K - 1
    jo %= len(seat)
    josephus.append(str(seat.pop(jo)))

print("<" + ", ".join(josephus) + ">")