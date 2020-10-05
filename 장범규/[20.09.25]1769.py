x = input()

chk = 0
while True :
    if (len(x) != 1) :
        x = str(sum(list(map(int, x))))
        chk += 1
    else :
        print(chk)
        if (int(x)%3 == 0) :
            print("YES")
        else :
            print("NO")
        break