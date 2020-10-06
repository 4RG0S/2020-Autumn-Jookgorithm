from sys import stdin


def get_distance(pos1, pos2):
    return ((pos1[0] - pos2[0]) ** 2 + (pos1[1] - pos2[1]) ** 2) ** 0.5

xA, yA, xB, yB, xC, yC = tuple(map(int, stdin.readline().split()))
A, B, C = (xA, yA), (xB, yB), (xC, yC)

if (xB - xA) * (yC - yA) == (yB - yA) * (xC - xA):
    print(-1)
else:
    len_list = [get_distance(A, B), get_distance(A, C), get_distance(B, C)]
    print((max(len_list) - min(len_list)) * 2)