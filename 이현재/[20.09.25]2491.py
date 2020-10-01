n = int(input())

nums = [0 for _ in range(n)]
nums = list(map(int, input().split()))

dec_cnt = 1
inc_cnt = 1
max_increase = 1
max_decrease = 1
for i in range(1, n):
    if nums[i - 1] <= nums[i]:
        inc_cnt += 1
    else:
        inc_cnt = 1
    if nums[i - 1] >= nums[i]:
        dec_cnt += 1
    else:
        dec_cnt = 1

    max_increase = max(max_increase, inc_cnt)
    max_decrease = max(max_decrease, dec_cnt)

print(max(max_increase, max_decrease))