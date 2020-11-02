def main():
    n = int(input())
    int_list = list(map(int, input().split()))

    set_list = list(set(int_list))
    set_list.sort()
    print(*set_list)


if __name__ == '__main__':
    main()
