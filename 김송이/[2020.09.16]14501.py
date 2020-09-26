def main():
    n = int(input())
    max_price_list = [0 for _ in range(n + 2)]
    time_list = [0 for _ in range(n + 2)]
    price_list = [0 for _ in range(n + 2)]
    for day in range(1, n + 1):
        time, price = map(int, input().split())
        time_list[day] = time
        price_list[day] = price
        max_price_list[day] = price
    for day in range(n, 0, -1):
        if time_list[day] + day - 1 > n:  # 상담잡으면 퇴사일 넘길 경우
            max_price_list[day] = max_price_list[day + 1]
        else:
            max_price_list[day] = max(max_price_list[day + 1], price_list[day] + max_price_list[day + time_list[day]])
    print(max_price_list[1])


if __name__ == '__main__':
    main()
