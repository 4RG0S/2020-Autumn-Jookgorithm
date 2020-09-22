#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>

class Point {
public:
	int x;
	int y;

	Point(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

int tomato(int** container, int n, int m);
std::queue<Point> get_init_tomato(int** container, int n, int m, bool** visited);
bool is_contain_zero(int** container, int n, int m);

int main() {

	int m, n;
	std::cin >> m >> n;

	// allocating
	int** container;
	container = (int**)malloc(n * sizeof(int*));
	for (int i = 0; i < n; i++)
		container[i] = (int*)malloc(m * sizeof(int));

	// input
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			std::cin >> container[i][j];


	std::cout << tomato(container, n, m);
	

	// release
	for (int i = 0; i < n; i++)
		delete[] container[i];
	delete[] container;
	
	
}

int tomato(int** container, int n, int m) {

	int dxy[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

	bool** visited;
	visited = (bool**)malloc(n * sizeof(bool*));
	for (int i = 0; i < n; i++)
		visited[i] = (bool*)malloc(m * sizeof(bool));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			visited[i][j] = false;

	std::queue<Point> queue = get_init_tomato(container, n, m, visited);

	int gen = 0;
	while(!queue.empty()) {

		std::queue<Point> queue_tmp;

		while (!queue.empty()) {
			Point point = queue.front();
			queue.pop();
			container[point.y][point.x] = 1;
			for (int i = 0; i < 4; i++) {
				int dx = point.x + dxy[i][0];
				int dy = point.y + dxy[i][1];

				if (0 <= dx && dx < m && 0 <= dy && dy < n) {
					if (!visited[dy][dx] && container[dy][dx] != -1) {
						queue_tmp.push(Point(dx, dy));
						visited[dy][dx] = true;
						
					}
				}

			}
		}

		if (!is_contain_zero(container, n, m))
			break;
		gen++;
		queue = queue_tmp;
	}
	
	if (is_contain_zero(container, n, m))
		return -1;

	return gen;
}

std::queue<Point> get_init_tomato(int** container, int n, int m, bool** visited) {
	std::queue<Point> queue;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (container[i][j] == 1) {
				queue.push(Point(j, i));
				visited[i][j] = true;
			}
			else if (container[i][j] == -1) {
				visited[i][j] = true;
			}
		}
	}

	return queue;
}

bool is_contain_zero(int** container, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (container[i][j] == 0) return true;
		}
	}
	return false;
}