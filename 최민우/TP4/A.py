input()
stack = []
while True:
    line = input()
    if line == '고무오리 디버깅 끝':
        break
    if line == '문제':
        stack.append(0)
    else:
        if len(stack):
            stack.pop()
        else:
            stack.append(0)
            stack.append(0)

print('고무오리야 사랑해' if len(stack) == 0 else '힝구')
