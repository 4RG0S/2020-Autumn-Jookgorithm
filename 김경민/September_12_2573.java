package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class September_12_2573 {

	static int glacier[][];
	static boolean is_visit[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static int count_ocean(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (glacier[ty][tx] == 0)
				count++;
		}
		return count;
	}

	static void dfs(int x, int y) {
		is_visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(0 <= tx && tx < is_visit[0].length && 0 <= ty && ty < is_visit.length)
			{
				if (!is_visit[ty][tx] && glacier[ty][tx] > 0)
					dfs(tx, ty);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		int result = 0;
		glacier = new int[N][M];
		int temp[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				glacier[i][j] = Integer.parseInt(line.nextToken());
			}
		}
		for (int year = 0; year < 1000; year++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (glacier[i][j] > 0) {
						temp[i][j] = Math.max(0, glacier[i][j] - count_ocean(j, i));
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					glacier[i][j] = temp[i][j];
					//System.out.print(glacier[i][j] + " ");
				}
				//System.out.println();
			}
			//System.out.println();
			int count = 0;
			is_visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!is_visit[i][j] && glacier[i][j] > 0) {
						dfs(j, i);
						count++;
					}
				}
			}
			if (count >= 2) {
				result = year + 1;
				break;
			}
		}
		System.out.println(result);
	}

}
