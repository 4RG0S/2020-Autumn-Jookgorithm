n = int(input())
arr = sorted(list(map(int, input().split())), key=abs)
m = 10000000000
d = []
for i in range(-1, n-1):
    num = abs(arr[i] + arr[i+1])
    if num < m:
        m = num
        d = [arr[i],arr[i+1]]
d = sorted(d)
print(d[0], d[1])