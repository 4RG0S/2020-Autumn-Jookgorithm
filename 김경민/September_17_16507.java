package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class September_17_16507 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(line.nextToken());
		int C = Integer.parseInt(line.nextToken());
		int Q = Integer.parseInt(line.nextToken());
		int arr[][] = new int[R][C];
		int sum[][] = new int[R][C];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(line.nextToken());
				if (i == 0)
					sum[i][j] = arr[i][j];
			}
		}
		for (int i = 1; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum[i][j] = sum[i - 1][j] + arr[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 1; j < C; j++) {
				sum[i][j] = sum[i][j - 1] + sum[i][j];
			}
		}
		for(int i=0;i<Q;i++)
		{
			line = new StringTokenizer(br.readLine(), " ");
			int sx, sy, ex, ey;
			sy = Integer.parseInt(line.nextToken()) - 1;
			sx = Integer.parseInt(line.nextToken()) - 1;
			ey = Integer.parseInt(line.nextToken()) - 1;
			ex = Integer.parseInt(line.nextToken()) - 1;
			int comp = sum[ey][ex];
			if (sx > 0 && sy > 0) {
				comp = comp - sum[sy - 1][ex] - sum[ey][sx - 1] + sum[sy - 1][sx - 1];
			} else if (sx > 0) {
				comp = comp - sum[ey][sx - 1];
			} else if (sy > 0) {
				comp = comp - sum[sy - 1][ex];
			}
			comp /= (Math.abs(sx - ex) + 1)*(Math.abs(sy - ey) + 1);
			System.out.println(comp);
		}
	}

}
