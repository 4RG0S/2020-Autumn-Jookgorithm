import sys

trees = {}
count = 0
for line in sys.stdin :
    line = line.rstrip()
    if line in trees :
        trees[line] += 1
    else :
        trees[line] = 1
    count += 1

tree = sorted(trees.items(),key=lambda x:x[0])

for i in tree :
    print(i[0],format(i[1]/count*100,".4f"))