def main():
    str = input()

    word = ''
    result = ''
    tag = False
    for c in str:
        if c == ' ':
            if tag == False:  # 꺽쇠 x
                result += word[::-1]
                result += c
                word = ''
            else:  # 꺽쇠 O
                result += word
                result += c
                word = ''
        elif c == '<':
            result += word[::-1]
            word = ''
            word += c
            tag = True
        elif c == '>':
            word += c
            result += word
            word = ''
            tag = False
        else:
            word += c
    result += word[::-1]
    print(result)


if __name__ == '__main__':
    main()
