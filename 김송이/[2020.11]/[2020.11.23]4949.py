def main():
    stack = []
    dic={')':'(' , ']':'['}
    while True:
        flag = True
        string = input()
        if string =='.':
            break
        for s in string:
            if s == '(' or s == '[':
                stack.append(s)
            elif s == ')' or s == ']':
                if not stack:
                    print('no')
                    flag = False
                    break
                elif stack[-1] == dic[s]:
                    stack.pop()
                else:
                    print('no')
                    flag = False
                    break
        if not stack and flag ==True:
            print('yes')
        if stack and flag == True:
            print('no')
        stack = []

if __name__ == '__main__':
    main()
