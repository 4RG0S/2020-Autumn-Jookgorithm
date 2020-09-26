def main():
    n = int(input())
    li = [1,1]
    for i in range(2,n+1):
        li += [(li[i-1] + li[i-2] + 1)%1000000007]
    print(li[n])

if __name__ == '__main__':
    main()