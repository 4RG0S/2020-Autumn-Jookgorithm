import sys
input = sys.stdin.readline

n,m = map(int, input().split())
tree_list = list(map(int, input().split()))

l,r,result = 0,max(tree_list),0
while (l <= r) :
    mid = (l+r)//2
    tree = 0
    for i in tree_list :
        if (i-mid >= 0) :
            tree += i-mid
    if (tree >= m) :
        result = max(result,mid)
        l = mid+1
    else :
        r = mid-1
print(result)