L = int(input())
advertisement_string = input()
pi = [0 for temp in range(L)]

j = 0
for i in range(1, L):
    while j > 0 and advertisement_string[i] != advertisement_string[j]:
        j = pi[j - 1]
    if advertisement_string[i] == advertisement_string[j]:
        j += 1
        pi[i] = j

print(L - pi[L - 1])
