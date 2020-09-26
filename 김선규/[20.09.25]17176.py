def main():
    n = int(input())
    li = sorted(list(map(int, input().split())))
    s = sorted(list(input()))
    n = True
    for i in range(len(li)):
        if li[i] is 0:
            li[i] += 32
        elif li[i] < 27:
            li[i] += 64
        else:
            li[i] += 70

        if chr(li[i]) != s[i]:
            n = False

    print('y' if n else 'n')
    

if __name__ == '__main__':
    main()