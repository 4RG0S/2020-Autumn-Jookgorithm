from sys import stdin

stdin.readline()
A = list(map(int, stdin.readline().split()))

print(min(A) * max(A))
