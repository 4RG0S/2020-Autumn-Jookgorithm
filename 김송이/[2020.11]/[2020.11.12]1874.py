from collections import deque


def main():
    n = int(input())
    sample_list = deque([])
    result = []
    for i in range(n):
        sample_list.append(int(input()))
    stack = [1]
    result.append('+')
    i = 2
    flag = True
    while sample_list:
        if not stack:
            stack.append(i)
            result.append('+')
            i += 1
        while sample_list[0] > stack[-1]:
            stack.append(i)
            result.append('+')
            i += 1

        if stack[-1] != sample_list[0]:  # 스택으로 만드는 것이 불가능 한 경우
            flag = False
            break
        else:  # 가능한 경우
            stack.pop()
            result.append('-')
            sample_list.popleft()

    if flag == False:
        print('NO')
    else:
        print(*result,sep='\n')


if __name__ == '__main__':
    main()
