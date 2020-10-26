def main():
    a, b = map(int, input().split())
    result_max = 1 #최대공약수 초기화

    for i in range(2,min(a,b)+1):
        if a%i==0 and b%i==0:
            result_max = i

    print(result_max)

    result_min = (a//result_max)*b
    print(result_min)


if __name__ == '__main__':
    main()
