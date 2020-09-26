#include <iostream>
#include <vector>
#include <stdlib.h>
#include <algorithm>
#include <unistd.h>

using namespace std;

static int area = 0;
static int dx[] = {1, -1, 0, 0};
static int dy[] = {0, 0, 1, -1};

void dfs(int x, int y, bool **board, int x_max, int y_max)
{
  board[y][x] = true;
  area++;

  for (int i = 0; i < 4; i++)
  {
    int tx = x + dx[i];
    int ty = y + dy[i];
    if (0 <= tx && tx < x_max && 0 <= ty && ty < y_max)
    {
      if (!board[ty][tx])
        dfs(tx, ty, board, x_max, y_max);
    }
  }
}

int main()
{
  vector<int> sum_of_area;
  int M, N, K;
  cin >> M >> N >> K;
  bool **board = (bool **)malloc(sizeof(bool *) * M);
  int count = 0;
  for (int i = 0; i < M; i++)
  {
    board[i] = (bool *)malloc(sizeof(bool) * N);
    for (int j = 0; j < N; j++)
    {
      board[i][j] = false;
    }
  }
  for (int i = 0; i < K; i++)
  {
    int s_x, s_y, e_x, e_y;
    cin >> s_x >> s_y >> e_x >> e_y;
    //cout << sx << sy << ex << ey;

    for (int y = s_y; y < e_y; y++)
    {

      for (int x = s_x; x < e_x; x++)
      {
        board[y][x] = true;
      }
    }
  }

  for (int i = 0; i < M; i++)
  {
    for (int j = 0; j < N; j++)
    {
      area = 0;
      if (!board[i][j])
      {
        dfs(j, i, board, N, M);
      }
      if (area != 0)
      {
        sum_of_area.push_back(area);
        count++;
      }
    }
  }
  sort(sum_of_area.begin(), sum_of_area.end());
  cout << count << '\n';
  for (int i = 0; i < sum_of_area.size(); i++)
  {
    cout << sum_of_area.at(i) << " ";
  }
}
