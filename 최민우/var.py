for _ in range(int(input())):
    stack = []
    hasResult = False
    for c in input():
        if c == '(':
            stack.append(c)
        else:
            if len(stack) == 0:
                # 강제로 pop 하려고함 // pop 하려는데 원소가 없음
                hasResult = True
                break
            stack.pop()

    # False = 0, True = 0 이 아닌 값
    if hasResult or len(stack) != 0:
        print('NO')
    else:
        print('YES')
