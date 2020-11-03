from sys import stdin

def isGroupWord(word):
    GroupWordCheck = []
    for alphabet in word:
        if alphabet in GroupWordCheck:
            if alphabet != GroupWordCheck[-1]:
                return False
        else:
            GroupWordCheck.append(alphabet)
    return True

N = int(stdin.readline())
result = 0

for i in range(N):
    if isGroupWord(stdin.readline().rstrip()):
        result += 1

print(result)
