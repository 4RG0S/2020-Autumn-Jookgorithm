import re

S = input()
K = input()
S = re.sub('[0-9]', '', S)
print(1 if K in S else 0)