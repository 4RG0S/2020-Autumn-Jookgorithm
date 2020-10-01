import sys
input=sys.stdin.readline

def greedy(meeting):
    meeting_count = 0
    start_time = 0

    for time in meeting:
        if time[0] >= start_time:
            start_time = time[1]
            meeting_count += 1
    return meeting_count

M = int(input())
meeting = list()
for i in range(M):
    start, end = map( int , input().split() )
    meeting.append((start, end))

meeting = sorted( meeting, key= lambda x : x[0] )
meeting = sorted( meeting, key= lambda x : x[1] )
print(greedy(meeting))
