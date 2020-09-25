def main():
    n = int(input())
    stack = []
    for i in range(n):
        RESULT = 'NO'
        str = input()
        for j in range(len(str)):
            if not stack:
                stack.append(str[j])
            elif stack[-1] == '(' and str[j] == ')':
                stack.pop()
            else:
                stack.append(str[j])
        if not stack:
            RESULT = 'YES'
        print(RESULT)
        stack=[]


if __name__ == '__main__':
    main()
