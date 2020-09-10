#BOJ 11576

a,b = map(int, input().split())
n = int(input())
li = [int(x) for x in input().split()]
re = 0
result = []

for i in li:
  re += i*(a**(n-1))
  n = n-1

while re!=0:
  result.append(re%b)
  re = re//b
  
for x in result[::-1]:
  print(x, end=' ')
