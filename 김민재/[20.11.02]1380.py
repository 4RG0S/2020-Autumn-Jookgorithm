from sys import stdin

n = int(stdin.readline())
lost_girl_list = []

while n != 0:
    girl_list = []
    num_list = []
    for i in range(n):
        girl_list.append(stdin.readline().rstrip())
    for i in range(2*n-1):
        num, alpha = stdin.readline().split()
        num = int(num)
        if num in num_list:
            num_list.remove(num)
        else:
            num_list.append(num)
    lost_girl_list.append(girl_list[num_list[0]-1])
    n = int(stdin.readline())

for index, name in enumerate(lost_girl_list, start=1):
    print(index, name)
