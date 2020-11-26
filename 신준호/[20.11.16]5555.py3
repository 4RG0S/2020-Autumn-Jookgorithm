regex = input()
n = int(input())

rings = list()
for _ in range(n):
    rings.append(input())

cnt = 0
for ring in rings:
    if regex in ring + ring: cnt += 1

print(cnt)