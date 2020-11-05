import sys
input = sys.stdin.readline

def chk(n) :
    n = list(str(n))
    for i in n :
        if int(i) in broken_list :
            return False
    return True

target = int(input())
broken = int(input())
broken_list = list(map(int, input().split()))

button = [0,1,2,3,4,5,6,7,8,9]
for i in broken_list :
    button.remove(i)

result = abs(target-100)

for i in range(1000001) :
    if chk(i) :
        result = min(result,len(str(i))+abs(i-target))
print(result)