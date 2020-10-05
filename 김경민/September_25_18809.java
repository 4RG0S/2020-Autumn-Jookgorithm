package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class September_25_18809 {

	// 초록 == -1 빨강 == -2

	static int map[][];
	static int red_time[][];
	static int green_time[][];
	static boolean invalid[][];
	static int N, M, G, R;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int max = Integer.MIN_VALUE;

	static class dot {
		int x, y, time;

		public dot(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static void combination_green(int start, int n, int r) {
		if (r == 0) {
			combination_red(0, n, R);
			return;
		} else {
			for (int i = start; i < n; i++) {
				if (map[i / map[0].length][i % map[0].length] == 2) {
					map[i / map[0].length][i % map[0].length] = -1;
					combination_green(i + 1, n, r - 1);
					map[i / map[0].length][i % map[0].length] = 2;
				}
			}
		}
	}

	static void combination_red(int start, int n, int r) {
		if (r == 0) {
			time_flow();
			return;
		} else {
			for (int i = start; i < n; i++) {
				if (map[i / map[0].length][i % map[0].length] == 2) {
					map[i / map[0].length][i % map[0].length] = -2;
					combination_red(i + 1, n, r - 1);
					map[i / map[0].length][i % map[0].length] = 2;
				}
			}
		}
	}

	static void time_flow() {
		Queue<dot> green = new LinkedList<>();
		Queue<dot> red = new LinkedList<>();
		int count = 0;
		green_time = new int[N][M];
		red_time = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					green.add(new dot(j, i, 0));
					green_time[i][j] = -1;
				}
				if (map[i][j] == -2) {
					red.add(new dot(j, i, 0));
					red_time[i][j] = -1;
				}
			}
		}
		for (int time = 0; !green.isEmpty() || !red.isEmpty(); time++) {
			while (!green.isEmpty() && green.peek().time == time) {
				dot temp = green.poll();
				if(red_time[temp.y][temp.x] == 0)
				{
					for (int i = 0; i < 4; i++) {
						int x = temp.x + dx[i];
						int y = temp.y + dy[i];
						if (is_range(x, y) && map[y][x] != 0 && green_time[y][x] == 0) {

							green_time[y][x] = time + 1;
							green.add(new dot(x, y, time + 1));
						}
					}
				}
					
			}
			while (!red.isEmpty() && red.peek().time == time) {
				dot temp = red.poll();
					for (int i = 0; i < 4; i++) {
						int x = temp.x + dx[i];
						int y = temp.y + dy[i];
						if (is_range(x, y) && map[y][x] != 0 && red_time[y][x] == 0) {
							if (temp.time + 1 == green_time[y][x]) {
								red_time[y][x] = time + 1;
							} else if (green_time[y][x] == 0 && map[y][x] != -1) {
								red_time[y][x] = time + 1;
								red.add(new dot(x, y, time + 1));
							}
						}
				}

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (red_time[i][j] == green_time[i][j] && green_time[i][j] != 0)
					count++;
			}
		}
		/*
		System.out.println("============green=============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(green_time[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============red==============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(red_time[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("count" + count);
		System.out.println("===========================");
		*/
		if (count > max)
			max = count;
	}

	static boolean is_range(int x, int y) {
		if (0 <= x && x < M && 0 <= y && y < N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(line.nextToken());
		M = Integer.parseInt(line.nextToken());
		G = Integer.parseInt(line.nextToken());
		R = Integer.parseInt(line.nextToken());
		map = new int[N][M];
		red_time = new int[N][M];
		green_time = new int[N][M];

		for (int i = 0; i < N; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line.nextToken());
			}
		}
		combination_green(0, N * M, G);
		System.out.println(max);
	}

}
