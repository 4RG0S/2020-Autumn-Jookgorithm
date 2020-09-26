vocas = set()

N = int(input())

for i in range(N):
    voca = input()
    vocas.add(voca)

voca_list = list(vocas)

for i in range(len(voca_list)):
    voca_list[i] = [len(voca_list[i]), voca_list[i]]

voca_list.sort()

for voca_length, voca_sort in voca_list:
    print(voca_sort)
