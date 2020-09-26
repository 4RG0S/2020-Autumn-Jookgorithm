def main():
    n = int(input())
    li = [1,1]
    for i in range(1, 2500):
        sum = 0
        for j in range(0, i+1):
            sum += li[j]*li[i-j]
        sum %= 1000000007
        li += [sum]

    for i in range(0, n):
        l = int(input())
        if l % 2 == 1:
            print(0)
        else:
            print(li[int(l/2)])

if __name__ == "__main__":
    main()