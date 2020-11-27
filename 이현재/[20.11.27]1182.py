from itertools import combinations

n, k = map(int, input().split())
num_list = list(map(int, input().split()))

result = 0
for i in range(1, n + 1):
    t_list = list(combinations(num_list, i))
    for j in t_list:
        if sum(j) == k:
            result += 1

print(result)