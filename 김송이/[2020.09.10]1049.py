def main():
    broken, brand = map(int, input().split())
    set_price, one_price, small_price = [], [], []

    for i in range(brand):
        a, b = map(int, input().split())
        set_price.append(a)
        one_price.append(b)

    min_set_price = min(set_price)
    min_one_price = min(one_price)

    # 세트 개수
    if broken > 6:
        set_num = broken // 6 + 1
    else:
        set_num = 1

    min_price = []
    for x in range(set_num + 1):
        for y in range(broken + 1):
            if 6 * x + y >= broken:
                min_price.append(min_set_price * x + min_one_price * y)
    print(min(min_price))


if __name__ == '__main__':
    main()
