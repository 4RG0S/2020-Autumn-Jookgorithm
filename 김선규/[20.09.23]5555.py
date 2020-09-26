def main():
    s1 = input()
    n = int(input())

    c = 0
    for i in range(n):
        s2 = input()
        s2 = s2[-len(s1):] + s2
        if s1 in s2:
            c += 1
    print(c)

if __name__ == '__main__':
    main()