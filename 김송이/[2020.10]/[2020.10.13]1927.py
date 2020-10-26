import heapq
def main():
    n= int(input())
    input_list = []
    heap = []
    for i in range(n):
        input_list.append(int(input()))
    for j in input_list:
        if j==0:
            if not heap:
                print(0)
            else:
                print(heapq.heappop(heap))
        else :
            heapq.heappush(heap,j)


if __name__ == '__main__':
    main()