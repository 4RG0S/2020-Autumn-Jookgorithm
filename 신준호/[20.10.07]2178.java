import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        boolean[][] map = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            for(int j = 0; j < m; j++)
                map[i][j] = input.charAt(j) == '1';
        }


        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        int cnt = 0;
        while(!queue.isEmpty()) {
            Queue<Point> tmp = new ArrayDeque<>();
            boolean isEnd = false;

            while(!queue.isEmpty()) {
                Point point = queue.poll();
                int row = point.r;
                int col = point.c;

                if(row == n - 1 && col == m - 1) {
                    isEnd = true;
                    break;
                }

                if(row - 1 >= 0){
                    if(!visited[row - 1][col] && map[row - 1][col]) {
                        visited[row - 1][col] = true;
                        tmp.add(new Point(row - 1, col));
                    }
                }

                if(col - 1 >= 0) {
                    if(!visited[row][col - 1] && map[row][col - 1]) {
                        visited[row][col - 1] = true;
                        tmp.add(new Point(row, col - 1));
                    }
                }

                if(row + 1 < n) {
                    if(!visited[row + 1][col] && map[row + 1][col]) {
                        visited[row + 1][col] = true;
                        tmp.add(new Point(row + 1, col));
                    }
                }

                if(col + 1 < m) {
                    if(!visited[row][col + 1] && map[row][col + 1]) {
                        visited[row][col + 1] = true;
                        tmp.add(new Point(row, col + 1));
                    }
                }
            }


            queue = tmp;
            cnt++;
            if(isEnd) break;
        }

        System.out.print(cnt);

    }

    public static class Point{
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}
