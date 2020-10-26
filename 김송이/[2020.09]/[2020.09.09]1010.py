def main(case):
    while (case != 0):
        left, right = map(int, input().split())
        combination = 1
        for i in range(left):
            combination *= right
            right -= 1
        for j in range(left):
            combination = (combination // left)
            left -= 1
        print(combination)
        case -= 1


if __name__ == '__main__':
    main(int(input()))
