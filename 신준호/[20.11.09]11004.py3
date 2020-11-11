N, K = input().split()

nums = list(map(int, input().split()))
nums.sort()
print(nums[int(K)-1])

