import sys

sys.setrecursionlimit(10 ** 8)


def dfs(index, value, visited, total_visited):
    if index in total_visited:
        return True, None
    visited.add(index)
    total_visited.add(index)

    if value in visited:
        global team
        team += 1
        return (index == value), value

    is_cycle, start_index = dfs(value, field[value], visited, total_visited)
    if not is_cycle:
        team += 1
        if index == start_index:
            is_cycle = True

    return is_cycle, start_index


for _ in range(int(input())):
    n = int(input())
    field = list(map(int, input().split()))
    field = [x - 1 for x in field]
    team = 0
    visited = set()
    for index, value in enumerate(field):
        if index in visited:
            continue
        dfs(index, value, set(), visited)

    print(n - team)
