def func(li, n):
    if len(li) == 6:
        print(' '.join(map(str, li)))
    else:
        for i in range(len(li)-1, n, -1):
            copyli = li.copy()
            copyli.remove(li[i])
            func(copyli, i-1)

def main():
    while True :
        li = list(map(int, input().split()))
        if li[0] == 0: break
        li = func(li[1:], -1)
        print()

if __name__ == "__main__":
    main()