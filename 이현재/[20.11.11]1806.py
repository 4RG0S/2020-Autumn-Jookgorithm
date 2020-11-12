import sys


def sub_sum(arr, target, n):
    left = right = length = sum = 0
    result = 1e8
    while True:
        if sum >= target:
            result = min(result, length)
            sum -= arr[left]
            left += 1
            length -= 1
        else:
            if right == n:
                break
            sum += arr[right]
            right += 1
            length += 1
    return result


if __name__ == '__main__':
    input = sys.stdin.readline
    n, s = map(int, input().split())
    lst = list(map(int, input().split()))
    answer = sub_sum(lst, s, n)
    print(answer if answer != 1e8 else 0)
