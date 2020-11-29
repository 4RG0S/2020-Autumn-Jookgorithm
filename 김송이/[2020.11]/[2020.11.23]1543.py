def main():
    string = input()
    word = input()
    count = 0
    while True:
        s =string.find(word)
        if s != -1:
            count+=1
            str_list = list(string)
            for i in range(len(word)):
                str_list.pop(s)
            str_list.insert(s, ".")
            string = ''.join(str_list)

        else:
            break
    print(count)


if __name__ == '__main__':
    main()