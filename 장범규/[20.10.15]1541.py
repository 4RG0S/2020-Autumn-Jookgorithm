import sys
input = sys.stdin.readline

exp = list(input().rstrip())

i = 0
minus = 0
while True :
    try :
        if (exp[i] == '-') :
            if (minus == 0) :
                exp.insert(i+1,'(')
                minus = 1
            else :
                exp.insert(i,')')
                minus = 0
    except :
        if (minus == 1) :
            exp.append(')')
        break
    i += 1

n = ''
result = []
for c in exp :
    if (c == '(') :
        result.append(c)
    elif (c == '+' or c == '-' or c == ')') :
        try :
            result.append(str(int(n)))
            result.append(c)
            n = ''
        except :
            result.append(c)
    else :
        n += c
if (n != '') :
    result.append(str(int(n)))

print(eval(''.join(result)))