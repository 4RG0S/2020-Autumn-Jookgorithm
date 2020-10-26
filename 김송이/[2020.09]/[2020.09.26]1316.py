def main():
    n = int(input())
    count = 0
    str_list = [input() for _ in range(n)]

    for str in str_list:
        check = False
        for j in range(len(str) - 1):
            if str[j] != str[j + 1]:
                sub_str = str[j + 2:]
                if str[j] in sub_str:
                    check = True
                    break;
        if check == False:
            count += 1
    print(count)


if __name__ == '__main__':
    main()
