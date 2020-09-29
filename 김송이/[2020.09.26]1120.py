def count(A, B, interval):  # 차이 비교 함수
    count = 0
    for i in range(len(A)):
        if A[i] != B[i + interval]:
            count += 1
    return count


def main():
    str_list = list(input().split())
    list_A = list(str_list[0])
    list_B = list(str_list[1])
    min_result = len(list_A)
    if len(list_A) == len(list_B):
        print(count(list_A, list_B, 0))
    else:
        interval = len(list_B) - len(list_A)  # A와 B 위치 차이
        for i in range(0, interval + 1):
            current_min = count(list_A, list_B, i)
            min_result = min(current_min, min_result)
        print(min_result)


if __name__ == '__main__':
    main()
