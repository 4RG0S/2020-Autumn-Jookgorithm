def main():
    n = input()
    card_list = list(map(int, input().split()))
    n = input()
    sangen_list = list(map(int, input().split()))

    card_list.sort()
    result = []
    for temp in sangen_list:
        left = 0
        right = len(card_list) - 1
        while left <= right:
            mid = (left + right) // 2
            if temp > card_list[mid]:
                left = mid + 1
            elif temp < card_list[mid]:
                right = mid - 1
            else:
                result.append(1)
                break
        if card_list[mid] != temp:
            result.append(0)
    print(*result)


if __name__ == '__main__':
    main()
