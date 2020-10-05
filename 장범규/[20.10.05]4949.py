import sys

while True :
    line = sys.stdin.readline().rstrip()
    if (line == '.') :
        break

    chk = 1
    stack = []
    for i in line :
        if (i == '[' or i == '(') :
            stack.append(i)
        elif (i == ']') :
            if stack :
                if (stack.pop() != '[') :
                    chk = 0
                    break
            else :
                chk = 0
                break
        elif (i == ')') :
            if stack :
                if (stack.pop() != '(') :
                    chk = 0
                    break
            else :
                chk = 0
                break
    if stack :
        print("no")
        continue    
    if (chk == 0) :
        print("no")
    else :
        print("yes")
