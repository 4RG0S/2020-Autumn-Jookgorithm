def main():
    n = int(input())
    float_list = []
    for i in range(n):
        float_list.append(float(input()))
    max_result = float_list[0]
    current_max = float_list[0]
    for i in range(1, n):
        current_max = max(current_max * float_list[i], float_list[i])
        max_result = max(current_max, max_result)
    print('%.3f'%max_result)


if __name__ == '__main__':
    main()
