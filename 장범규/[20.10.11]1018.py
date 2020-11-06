n,m = map(int , input().split())
board = []
for i in range(n) :
    board.append(list(input()))

chk = []
for c in range(m-7) :
    for r in range(n-7) :
        s = board[r][c]
        count = 0
        if (r%2 == 0) :
            r_odd = 0
        else :
            r_odd = 1
        if (c%2 == 0) :
            c_odd = 0
        else :
            c_odd = 1
        for i in range(r,r+8) :
            if (r_odd == 1) :
                if (i%2 == 0) :
                    if (s == 'B') :
                        chk_s = 'W'
                    else :
                        chk_s = 'B'
                else :
                    chk_s = s
            else :
                if (i%2 == 0) :
                    chk_s = s
                else :
                    if (s == 'B') :
                        chk_s = 'W'
                    else :
                        chk_s = 'B'
            for j in range(c,c+8) :
                if (c_odd == 1) :
                    if (j%2 == 0) :
                        if (chk_s == board[i][j]) :
                            count += 1
                    else :
                        if (chk_s != board[i][j]) :
                            count += 1
                else :
                    if (j%2 == 0) :
                        if (chk_s != board[i][j]) :
                            count += 1
                    else :
                        if (chk_s == board[i][j]) :
                            count += 1
        chk.append(count)
        chk.append(64-count)
print(min(chk))