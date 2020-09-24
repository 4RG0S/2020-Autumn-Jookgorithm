crypto = input()
n = int(input())
dic = []
for i in range(n) :
    dic.append(input())

length = len(crypto)
search = 0
while True :
    for i in dic :
        if (crypto.find(i) != -1) :
            search = 1
            break
    if (search == 1) :
        break
    else :
        crypto = list(crypto)
        for i in range(length) :
            crypto[i] = chr((ord(crypto[i])-ord('a')+1)%26+ord('a'))
        crypto = ''.join(crypto)

print(crypto)