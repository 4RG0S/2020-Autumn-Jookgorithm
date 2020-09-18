import sys
from sys import stdin

N, K = map(int, stdin.readline().split())
soldiers = [list(map(int, stdin.readline().split())) for _ in range(N)]
soldiers.sort()

result = sys.maxsize

for agility in range(N):
    for intelligent in range(N):
        count = 0
        for soldier in range(N):
            if soldiers[agility][1] >= soldiers[soldier][1] and soldiers[intelligent][2] >= soldiers[soldier][2]:
                count += 1
            if count >= K:
                result = min(result, soldiers[soldier][0] + soldiers[agility][1] + soldiers[intelligent][2])
                break

print(result)
