from collections import deque

n = int(input())
deck = [i for i in range(1, n + 1)]
deck = deque(deck)

while len(deck) > 1:
    deck.popleft()
    deck.append(deck.popleft())

print(deck.popleft())
