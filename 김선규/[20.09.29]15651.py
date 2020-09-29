def func(n, m, li):
    if m == 0:
        for i in li:
            print(i, end=' ')
        print()
    else:
        for i in range(1, n+1):
            func(n, m-1, li+[i])

def main():
    nm = list(map(int, input().split()))
    func(nm[0], nm[1], [])

if __name__ == '__main__':
    main()