def main():
    n = int(input())
    time_list = list(map(int, input().split()))

    time_list.sort()
    sum = 0
    for i in range(len(time_list)):
        for j in range(i + 1):
            sum += time_list[j]
    print(sum)


if __name__ == '__main__':
    main()
