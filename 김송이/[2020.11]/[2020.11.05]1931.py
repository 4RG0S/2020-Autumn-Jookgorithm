def main():
    n = int(input())
    time_list = []
    for i in range(n):
        a,b = map(int,input().split())
        time_list.append((a,b))
    time_list.sort()
    time_list.sort(key=lambda x:x[1])
    #print(time_list)

    count = 0
    current_time = time_list[0][1]
    for i,t in enumerate(time_list):
        if i==0:
            count+=1
            continue
        if current_time <= t[0]:
            current_time = t[1]
            count+=1
    print(count)


if __name__ == '__main__':
    main()
