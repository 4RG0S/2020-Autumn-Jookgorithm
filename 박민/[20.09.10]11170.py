def solve(nm_set):
    for i in range(len(nm_set)):
        n = int(nm_set[i][0])
        m = int(nm_set[i][1])
        cnt = 0

        for num in range(n, m + 1):
            cnt += str(num).count('0')

        print(cnt)



if __name__ == '__main__':
    t = int(input())
    input_set = list()
    for i in range(t):
        input_set.append(input().split())

    solve(input_set)