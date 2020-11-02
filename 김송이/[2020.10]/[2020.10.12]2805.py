def main():
    n, m = map(int,input().split())
    tree_list=list(map(int,input().split()))
    #절단기 높이 탐색
    left = 0
    right= max(tree_list)
    #절단기 높이가 최대가 되어야 나무를 적게 베는 것
    while left<=right:
        sum = 0
        mid = (left+right)//2
        for i in tree_list:
            if i-mid >0:
                sum+=(i-mid)
        if sum >= m: #가져갈라고 하는 양보다 많이 벤 경우
            answer = mid
            left = mid + 1
        elif sum<m: #가져갈라고 하는 양보다 적게 벤 경우
            right = mid -1
    print(answer)

if __name__ == '__main__':
    main()