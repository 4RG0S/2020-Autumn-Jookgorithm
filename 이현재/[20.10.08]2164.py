from collections import deque

n = int(input())
card = deque(range(1, n + 1))
while len(card) > 1:
    card.popleft()
    if len(card) == 1:
        break
    temp = card.popleft()
    card.append(temp)

print(*card)
