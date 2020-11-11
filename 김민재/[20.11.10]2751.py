from sys import stdin

N = int(stdin.readline())

print(*sorted([int(stdin.readline()) for _ in range(N)]))
