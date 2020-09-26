#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>

int get_papers(bool** paper, int row, int col, int n);
int isblue(bool** paper, int row, int col, int n);
int iswhite(bool** paper, int row, int col, int n);

int main() {

	int n;
	std::cin >> n;

	bool** paper;
	paper = (bool**)malloc(n * sizeof(int*));
	for (int i = 0; i < n; i++)
		paper[i] = (bool*)malloc(n * sizeof(int));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int val;
			std::cin >> val;
			paper[i][j] = val == 1;
		}
	}

	int p = get_papers(paper, 0, 0, n);
	std::cout << ((p & 0xFFFF0000) >> 16) << std::endl;
	std::cout << (p & 0x0000FFFF) << std::endl;
}

int get_papers(bool** paper, int row, int col, int n) {

	if (isblue(paper, row, col, n)) return 1;
	if (iswhite(paper, row, col, n)) return 0x00010000;
	//if (n == 1) return 0;

	int cnt = 0;
	cnt += get_papers(paper, row, col, n/2);
	cnt += get_papers(paper, row, col + n/2, n/2);
	cnt += get_papers(paper, row + n/2, col, n/2);
	cnt += get_papers(paper, row + n/2, col + n/2, n/2);

	return cnt;
}

int isblue(bool** paper, int row, int col, int n) {
	for (int i = row; i < row + n; i++) {
		for (int j = col; j < col + n; j++) {
			if (!paper[i][j]) return false;
		}
	}
	return true;
}

int iswhite(bool** paper, int row, int col, int n) {
	for (int i = row; i < row + n; i++) {
		for (int j = col; j < col + n; j++) {
			if (paper[i][j]) return false;
		}
	}
	return true;
}