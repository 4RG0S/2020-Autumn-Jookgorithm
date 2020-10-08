import heapq,sys

t = int(sys.stdin.readline())

for i in range(t) :
    oper = int(sys.stdin.readline())
    min_doubly_pq, max_doubly_pq = [], []
    del_min, del_max = [], []
    for j in range(oper) :
        cmd,data = sys.stdin.readline().rstrip().split()
        data = int(data)
        if (cmd == "I") :
            heapq.heappush(min_doubly_pq,data)
            heapq.heappush(max_doubly_pq,-data)
        else :
            if (data == 1) :
                if max_doubly_pq :
                    heapq.heappush(del_max, -heapq.heappop(max_doubly_pq))
            else :
                if min_doubly_pq :
                    heapq.heappush(del_min, -heapq.heappop(min_doubly_pq))

        while (max_doubly_pq and del_min) and (max_doubly_pq[0] == del_min[0]) : 
            heapq.heappop(max_doubly_pq)
            heapq.heappop(del_min)

        while (min_doubly_pq and del_max) and (min_doubly_pq[0] == del_max[0]) :
            heapq.heappop(min_doubly_pq)
            heapq.heappop(del_max)
    
    if not max_doubly_pq :
        print("EMPTY")
    else :
        print(-max_doubly_pq[0],min_doubly_pq[0])