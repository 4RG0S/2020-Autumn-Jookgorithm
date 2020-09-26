#include <iostream>
#include <stdlib.h>

using namespace std;

static int dx[] = {1, -1, 0, 0};
static int dy[] = {0, 0, 1, -1};

static void dfs(int x, int y, bool **is_visit, int N)
{
    is_visit[y][x] = true;
    for (int i = 0; i < 4; i++)
    {
        int tx = x + dx[i];
        int ty = y + dy[i];
        if (0 <= tx && tx < N && 0 <= ty && ty < N)
        {
            if (!is_visit[ty][tx])
            {
                dfs(tx, ty, is_visit, N);
            }
        }
    }
}

int main()
{
    int N;
    int result = 0;
    cin >> N;
    int **num_array = (int **)malloc(sizeof(int *) * N);
    bool **is_visit = (bool **)malloc(N * sizeof(bool *));
    for (int i = 0; i < N; i++)
    {
        num_array[i] = (int *)malloc(N * sizeof(int));
        is_visit[i] = (bool *)malloc(N * sizeof(bool));
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> num_array[i][j];
        }
    }

    int count = 0;
    for (int i = 0; i < 100; i++)
    {
        count = 0;
        for (int y = 0; y < N; y++)
        {
            for (int x = 0; x < N; x++)
            {
                is_visit[y][x] = false;
                if (num_array[y][x] <= i)
                    is_visit[y][x] = true;
            }
        }
        for (int y = 0; y < N; y++)
        {
            for (int x = 0; x < N; x++)
            {
                if (!is_visit[y][x])
                {
                    //cout << "sd";
                    dfs(x, y, is_visit, N);
                    count++;
                }
            }
        }
        if (result < count)
            result = count;
    }
    cout << result;
}
