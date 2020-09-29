import sys
input=sys.stdin.readline

N = int(input())
student = list()
for i in range(N):
    std_input = input().split()
    student.append(  (  std_input[0] , int( std_input[1]),int( std_input[2]),int( std_input[3])) )
student = sorted( student, key = lambda x : ( -x[1] , x[2], -x[3], x[0] ) )
for i in student:
    print(i[0])
