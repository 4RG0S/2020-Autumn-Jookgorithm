def move(arr, k, cnt):
    #print(arr) 리스트에 남은 것들 확인
    idx = arr.index(k)

    if idx == 0:
        arr.pop(0)
    else:
        if idx <= len(arr) - idx - 1:
            m = arr.pop(0)
            arr.append(m)
        else:
            m = arr.pop(len(arr) - 1)
            arr.insert(0, m)
        cnt += 1
        #print(cnt) 카운트 증가 확인
        return move(arr, k, cnt)

    return cnt


N, M = map(int, input().split())
x = list(map(int, input().split()))

queue = [i for i in range(1, N + 1)]

result = 0
for i in x:
    temp = 0
    result += move(queue, i, temp)

print(result)
