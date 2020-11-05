n = int(input())
count = 0
chk = 0
while True :
    if (str(count).find("666") != -1) :
        chk += 1
    if (chk == n) :
        print(count)
        break
    count += 1