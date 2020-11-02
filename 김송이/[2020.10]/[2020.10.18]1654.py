def main():
    k, n = map(int, input().split())
    k_list = [int(input()) for _ in range(k)]

    left = 1
    right = max(k_list)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        sum = 0
        if mid == 0:
            break
        for num in k_list:
            sum += num // mid
        if sum < n:
            right = mid - 1
        elif sum >= n:
            left = mid + 1
            answer = mid

    print(answer)


if __name__ == '__main__':
    main()
