from itertools import combinations

while True:
    lst = list(map(int, input().split()))
    if lst[0] == 0:
        break
    num_list = []
    for i in range(1, len(lst)):
        num_list.append(lst[i])
    num_list.sort()

    result = list(combinations(num_list, 6))
    for i in result:
        print(*i)
    print()
