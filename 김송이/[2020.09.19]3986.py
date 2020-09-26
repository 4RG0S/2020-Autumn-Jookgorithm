def main():
    n = int(input())
    word_list = []
    stack=[]
    count = 0

    for _ in range(n):
        word_list.append(input())

    for word in word_list:
        for i in range(0,len(word)):
            if not stack:
                stack.append(word[i])
            else:
                if stack[-1]==word[i]:
                    stack.pop()
                else:
                    stack.append(word[i])
        if not stack:
            count+=1
        stack=[]
    print(count)


if __name__ == '__main__':
    main()
