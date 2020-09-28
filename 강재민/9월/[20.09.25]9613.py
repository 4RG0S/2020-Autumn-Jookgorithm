def gcd(a, b):
    mod = a%b
    while mod > 0:
        a = b
        b = mod
        mod = a%b
    return b
    
inputNum = int(input())

for i in range(inputNum):
    inputNums = list(map(int, input().split()))
    sum = 0
    
    for j in range(1, inputNums[0]+1):
        for k in range(1, inputNums[0]+1):
            if j != k:
                sum = sum + gcd(inputNums[j], inputNums[k])
    print(int(sum/2))