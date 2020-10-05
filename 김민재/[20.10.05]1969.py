from sys import stdin

N, M = map(int, stdin.readline().split())
dna = [stdin.readline().rstrip() for _ in range(N)]
result = ''
Hamming_Distance = 0
dna_map = 'ACGT'

for i in range(M):
    cnt = [0, 0, 0, 0]
    for j in range(N):
        cnt[dna_map.index(dna[j][i])] += 1

    dna_distance = max(cnt)
    dna_most_often = cnt.index(dna_distance)

    result += dna_map[dna_most_often]
    Hamming_Distance += N - dna_distance

print(result)
print(Hamming_Distance)
