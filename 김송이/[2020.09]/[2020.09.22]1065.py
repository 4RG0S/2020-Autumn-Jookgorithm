def main():
    n = input()
    sumOfHan = 99
    if int(n) < 100:
        sumOfHan = n
    else:
        for i in range(100, int(n) + 1): #한수 없는지 전부 돌면서 체크
            str_i = str(i)
            num = int(str_i[1]) - int(str_i[0])
            find = False
            for j in range(0, len(str_i) - 1): #한수 있으면 +1
                current_num = int(str_i[j + 1]) - int(str_i[j])
                if current_num == num:
                    num = current_num
                    find = True
                else:
                    find = False
                    break
            if find == True:
                sumOfHan += 1

    print(sumOfHan)


if __name__ == '__main__':
    main()
