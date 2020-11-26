n = int(input())

seedlings = list(map(int, input().split()))
seedlings.sort(reverse=True)

for idx in range(len(seedlings)):
    seedlings[idx] += idx + 2

print(max(seedlings))
