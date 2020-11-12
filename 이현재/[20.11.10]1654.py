def binarysearch(arr, start, end, target):
    answer = 0
    while start <= end:
        temp_sum = 0
        mid = (start + end) // 2
        for i in arr:
            temp_sum += i // mid
        if temp_sum < target:
            end = mid - 1
        else:
            start = mid + 1
            answer = max(answer, mid)

    return answer


if __name__ == '__main__':
    k, n = map(int, input().split())
    lst = []
    for _ in range(k):
        lst.append(int(input()))

    min_value = 1
    max_value = max(lst)
    print(binarysearch(lst, min_value, max_value, n))
