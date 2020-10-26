import itertools

n = int(input())
distance_cost = []

min_distance = float('inf');
for i in range(n):
    input_list = list(map(int, input().split()))
    distance_cost.append(input_list)

points = [i for i in range(n)]


def sum_distance(perm):
    distance = 0

    for j in range(0, n - 1):  # for문을 도는 동안 세 도시를 돈다.
        if distance_cost[perm[j]][perm[j + 1]] != 0:  # 갈 수 있는 도시만
            distance += distance_cost[perm[j]][perm[j + 1]]
        else:
            return -1
    if distance_cost[perm[-1]][perm[0]] != 0:  # 시작점으로 돌아오는 비용
        distance += distance_cost[perm[-1]][perm[0]]
    else:
        return -1

    return distance


for i in itertools.permutations(points):  # 순열마다 돈다
    perm = list(i)
    result = sum_distance(perm)
    if result != -1:
        min_distance = min(min_distance, result)
print(min_distance)
