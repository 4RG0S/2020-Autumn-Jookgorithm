A, B = list(map(int, input().split()))
_ = input()
nums = list(map(int, input().split()))

dec = 0
for pow, num in enumerate(nums[::-1]):
    dec += num * (A ** pow)

translated = list()
while dec > 0:
    translated.append(dec % B)
    dec = int(dec / B)

print(' '.join(list(map(str, translated[::-1]))))