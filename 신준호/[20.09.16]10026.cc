#include <iostream>
#include <algorithm>
#include <string>
#include <queue>

void area_fliping(int** board, int n, int r, int c, int color);

int main() {

	int n;
	int** board;
	int** board2;
	
	int* counter;
	int* counter2;

	std::cin >> n;

	// memory allocating
	board = (int**)malloc(n * sizeof(int*));
	for (int i = 0; i < n; i++)
		board[i] = (int*)malloc(n * sizeof(int));

	board2 = (int**)malloc(n * sizeof(int*));
	for (int i = 0; i < n; i++)
		board2[i] = (int*)malloc(n * sizeof(int));

	counter = (int*)malloc(3 * sizeof(int));
	counter2 = (int*)malloc(2 * sizeof(int));

	counter[0] = 0; counter[1] = 0; counter[2] = 0;
	counter2[0] = 0; counter2[1] = 0;

	
	// input
	for (int i = 0; i < n; i++) {
		std::string str;
		std::cin >> str;

		for (int j = 0; j < n; j++) {
			switch (str.at(j)) {
			case 'R':
				board[i][j] = 0; board2[i][j] = 0;
				break;
			case 'G':
				board[i][j] = 1; board2[i][j] = 0;
				break;
			case 'B':
				board[i][j] = 2; board2[i][j] = 1;
				break;
			}
		}
	}

	// counting

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] != -1) {
				counter[board[i][j]]++;
				area_fliping(board, n, i, j, board[i][j]);
			}

			if (board2[i][j] != -1) {
				counter2[board2[i][j]]++;
				area_fliping(board2, n, i, j, board2[i][j]);
			}
		}
	}

	std::cout << counter[0] + counter[1] + counter[2] << " ";
	std::cout << counter2[0] + counter2[1];

	// release
	for (int i = 0; i < n; i++)
		delete[] board[i];
	delete[] board;
	
	for (int i = 0; i < n; i++)
		delete[] board2[i];
	delete[] board2;

	delete[] counter;
	delete[] counter2;

	return 0;
}

void area_fliping(int** board, int n, int r, int c, int color) {

	board[r][c] = -1;

	int dxy[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

	for (int i = 0; i < 4; i++) {
		int dy = r + dxy[i][0];
		int dx = c + dxy[i][1];

		if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
			if (board[dy][dx] != -1 && board[dy][dx] == color) area_fliping(board, n, dy, dx, color);
		}
	}

}