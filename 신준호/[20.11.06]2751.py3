
n = int(input())

nums = list()
for _ in range(n):
    nums.append(int(input()))

nums.sort()
for num in nums:
    print(num)