import sys
input = sys.stdin.readline

string = input().rstrip()
l = len(string)
count0,count1 = 0,0
for i in range(l-1) :
    if (string[i] != string[i+1]) :
        if (string[i] == '0') :
            count1 += 1
        else :
            count0 += 1
if (string[-1] == '0') :
    count1 += 1
else :
    count0 += 1
print(min(count0,count1))