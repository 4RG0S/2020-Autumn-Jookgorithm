def main():
    n = input()
    list_A = list(map(int, input().split()))
    n2 = input()
    list_M = list(map(int, input().split()))

    for m in list_M:
        if m in list_A:
            print(1)
        else:
            print(0)


if __name__ == '__main__':
    main()
