col,row = map(int, input().split())
n_shop = int(input())
shop_list = []

for i in range(n_shop+1) :
    dirt,loc = map(int, input().split())
    shop_list.append([dirt,loc])

s_dirt,s_loc = shop_list[-1][0], shop_list[-1][1]
ld = []
for i in range(n_shop) :
    if (s_dirt == 1) :
        if (shop_list[i][0] == 1) :
            ld.append(abs(shop_list[i][1]-s_loc))
        elif (shop_list[i][0] == 2) :
            t1 = s_loc + shop_list[i][1] + row
            t2 = col*2 + row*2 - t1
            ld.append(min(t1,t2))
        elif (shop_list[i][0] == 3) :
            ld.append(shop_list[i][1]+s_loc)
        else :
            ld.append(shop_list[i][1]+col-s_loc)
    elif (s_dirt == 2) :
        if (shop_list[i][0] == 1) :
            t1 = s_loc + shop_list[i][1] + row
            t2 = col*2 + row*2 - t1
            ld.append(min(t1,t2))
        elif (shop_list[i][0] == 2) :
            ld.append(abs(shop_list[i][1]-s_loc))
        elif (shop_list[i][0] == 3) :
            ld.append(row-shop_list[i][1]+s_loc)
        else :
            ld.append(row-shop_list[i][1]+col-s_loc)
    elif (s_dirt == 3) :
        if (shop_list[i][0] == 1) :
            ld.append(shop_list[i][1]+s_loc)
        elif (shop_list[i][0] == 2) :
            ld.append(shop_list[i][1]+row-s_loc)
        elif (shop_list[i][0] == 3) :
            ld.append(abs(shop_list[i][1]-s_loc))
        else :
            t1 = s_loc + shop_list[i][1] + col
            t2 = col*2 + row*2 - t1
            ld.append(min(t1,t2))
    else :
        if (shop_list[i][0] == 1) :
            ld.append(col-shop_list[i][1]+s_loc)
        elif (shop_list[i][0] == 2) :
            ld.append(col-shop_list[i][1]+row-s_loc)
        elif (shop_list[i][0] == 3) :
            t1 = s_loc + shop_list[i][1] + col
            t2 = col*2 + row*2 - t1
            ld.append(min(t1,t2))
        else :
            ld.append(abs(shop_list[i][1]-s_loc))
print(sum(ld))