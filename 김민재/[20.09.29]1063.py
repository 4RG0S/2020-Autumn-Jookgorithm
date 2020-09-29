from sys import stdin


def moving(king_pos, stone_pos, commands):
    column = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
    row = ['1', '2', '3', '4', '5', '6', '7', '8']

    king_pos_x = column.index(king_pos[0])
    king_pos_y = row.index(king_pos[1])
    stone_pos_x = column.index(stone_pos[0])
    stone_pos_y = row.index(stone_pos[1])

    for command in commands:
        if command == 'R':
                king_pos_x += 1
        elif command == 'L':
                king_pos_x -= 1
        elif command == 'B':
                king_pos_y -= 1
        elif command == 'T':
                king_pos_y += 1

    if king_pos_x == stone_pos_x and king_pos_y == stone_pos_y:
        for command in commands:
            if command == 'R':
                    stone_pos_x += 1
            elif command == 'L':
                    stone_pos_x -= 1
            elif command == 'B':
                    stone_pos_y -= 1
            elif command == 'T':
                    stone_pos_y += 1

    if 7 >= king_pos_x >= 0 and 7 >= king_pos_y >= 0 and 7 >= stone_pos_x >= 0 and 7 >= stone_pos_y >= 0:
        king_pos = column[king_pos_x] + row[king_pos_y]
        stone_pos = column[stone_pos_x] + row[stone_pos_y]

    return king_pos, stone_pos

king, stone, move = stdin.readline().split()
move = int(move)

for i in range(move):
    king, stone = moving(king, stone, stdin.readline().rstrip())

print(king)
print(stone)
