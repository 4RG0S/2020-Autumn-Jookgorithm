n = int(input())
ropes = list()
for _ in range(n):
    ropes.append(int(input()))

ropes.sort(reverse=True)

max_ = 0
for i, rope in enumerate(ropes):
    tmp = rope * (i + 1)

    if tmp > max_:
        max_ = tmp

print(max_)