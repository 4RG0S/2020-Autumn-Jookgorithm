from collections import defaultdict


def main():
    n, m = map(int, input().split())
    dic = defaultdict(list)
    count = 0
    for _ in range(n):
        s = input().rstrip()
        dic[s[0]].append(s)
    for _ in range(m):
        s = input()
        if s in dic[s[0]]:
            count += 1
    print(count)


if __name__ == '__main__':
    main()
