def main():
    n = int(input())
    li = []
    for _ in range(n):
        li += [list(map(int, input().split()))]
    li = sorted(li)
    for i in li:
        print(*i)

if __name__ == '__main__':
    main()