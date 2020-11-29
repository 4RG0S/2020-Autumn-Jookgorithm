import heapq


def bfs(s):
    queue = []
    distance = {}
    heapq.heappush(queue, (0, s))
    distance[s] = 0
    result = '123456780'
    while queue:
        ss = heapq.heappop(queue)[1]

        if ss == result:
            return distance[ss]

        zero_index = ss.find('0')
        x, y = zero_index // 3, zero_index % 3  # x,y 좌표로 표현했을 때
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < 3 and 0 <= ny < 3:
                s_index = nx * 3 + ny  # 좌표를 다시 문자열 인덱스로
                ns = list(ss)
                ns[zero_index], ns[s_index] = ns[s_index], ns[zero_index]
                change_ss = ''.join(ns)

                if change_ss not in distance.keys():
                    h = 0
                    for i in range(len(change_ss)):
                        if change_ss[i] == '0':
                            continue
                        if change_ss[i] != result[i]:
                            h += 1
                    g = distance[ss] + 1
                    f = g + h  # 경로가중치 + 휴리스틱
                    distance[change_ss] = g
                    heapq.heappush(queue, (f, change_ss))

    return -1


def main():
    ss = ''
    for i in range(3):
        s = input()
        s = s.replace(' ', '')
        ss += s
    print(bfs(ss))


if __name__ == '__main__':
    main()
