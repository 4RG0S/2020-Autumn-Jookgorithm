def main():
    n = int(input())
    location = []
    for i in range(n):
        x, y = map(int, input().split())
        location.append((x, y))
    location.sort(key=lambda x: (x[1],x[0]))
    for s in location:
        print(s[0], s[1])


if __name__ == '__main__':
    main()
