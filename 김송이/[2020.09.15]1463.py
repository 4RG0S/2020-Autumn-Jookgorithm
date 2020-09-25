# DP 문제
# min(f(n/3)+1, f(n/2)+1, f(n-1)+1)

def main():
    n = int(input())

    count_list = [0 for _ in range(n + 1)]

    for i in range(1, n + 1):
        if i == 1:
            count_list[i] = 0
        else:
            count_list[i] = count_list[i - 1] + 1
            if i % 3 == 0 and count_list[i // 3] + 1 < count_list[i]:
                count_list[i] = count_list[i // 3] + 1
            if i % 2 == 0 and count_list[i // 2] + 1 < count_list[i]:
                count_list[i] = count_list[i // 2] + 1

    print(count_list[n])


if __name__ == '__main__':
    main()
