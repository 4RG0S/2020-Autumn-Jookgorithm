import sys


def binarysearch(arr, left, right, M):
    answer = 0
    while left <= right:
        sum = 0
        mid = int((left + right) / 2)
        for i in arr:
            temp = i - mid;
            if temp < 0:
                temp = 0
            sum += temp
        if sum < M:
            right = mid - 1
        else:
            answer = max(answer, mid)
            left = mid + 1

    return answer


min_value = 0
max_value = -sys.maxsize - 1

N, M = map(int, input().split())

tree = [i for i in range(N)]
tree = list(map(int, input().split()))

for i in range(len(tree)):
    cur = tree[i]
    if cur > max_value:
        max_value = cur

print(binarysearch(tree, min_value, max_value, M))
