from collections import deque


def josephus(N, K):
    queue = deque()
    permutation = []
    for i in range(1, N + 1):
        queue.append(i)
    count = 0
    while queue:
        p = queue.popleft()
        count += 1
        if count == K:
            permutation.append(p)
            count = 0
            continue
        queue.append(p)
    return permutation


if __name__ == '__main__':
    N, K = map(int, input().split())
    result = josephus(N, K)
    print('<', end='')
    for i in range(len(result)):
        if i + 1 == N:
            print(result[i], end='>')
        else:
            print(result[i], end=', ')
