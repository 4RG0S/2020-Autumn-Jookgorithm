#BOJ 2004

def div(n, k):
  cnt = 0
  while n!=0:
    n = n//k
    cnt += n
  return cnt

n,m=map(int, input().split())

a = div(n, 2)-div(m,2)-div(n-m,2)
b = div(n, 5)-div(m,5)-div(n-m,5)

print(min(a,b))
