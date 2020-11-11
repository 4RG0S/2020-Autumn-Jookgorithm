from sys import stdin

input_string = stdin.readline().rstrip()

croatia = ('c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=')
for i in croatia:
    input_string = input_string.replace(i, '*')

print(len(input_string))
