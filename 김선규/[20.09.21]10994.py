def func(li, n, k):
    if n == 1:
        li[k][k] = '*'
        return li
    else:
        for i in range(4*n-3):
            li[k+0][k+i] = '*'
            li[k+i][k+0] = '*'
            li[k+i][k+4*(n-1)] = '*'
            li[k+4*(n-1)][k+i] = '*'
        return func(li, n-1, k+2)

def main():
    n = int(input())
    li = [[' ' for _ in range(4*n-3)] for _ in range(4*n-3)]
    li = func(li, n, 0)
    for i in range(4*n-3):
        for j in range(4*n-3):
            print(li[i][j] , end='')
        print()

if __name__ == "__main__":
    main()