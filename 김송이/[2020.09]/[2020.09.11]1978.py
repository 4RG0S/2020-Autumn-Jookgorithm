def main():
    n = int(input())
    int_list = list(map(int, input().split()))
    count = 0
    for num in int_list:
        if num == 1:
            continue
        for i in range(2, num + 1):
            if num % i == 0:
                break
        if num == i:
            count += 1

    print(count)


if __name__ == '__main__':
    main()
