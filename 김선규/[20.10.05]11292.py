def main():
    n = int(input())
    while n != 0:
        li = []
        m = 0
        for i in range(n):
            a, b = input().split()
            b = float(b)
            if m < b:
                m = b
                li = [a]
            elif m == b:
                li += [a]
        print(*li)
        n = int(input())

if __name__ == '__main__':
    main()