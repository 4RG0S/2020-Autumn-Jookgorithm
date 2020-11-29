def main():
    n = int(input())  # 색종이 개수
    matrix_list = [[0 for _ in range(101)] for _ in range(101)]
    #print(matrix_list)
    for i in range(n):
        a, b = map(int, input().split())
        for x in range(a,a+10):
            for y in range(b,b+10):
                matrix_list[x][y]=1
    sum = 0
    for i in range(101):
        for j in range(101):
            if matrix_list[i][j]==1:
                sum+=1
    print(sum)



if __name__ == '__main__':
    main()
