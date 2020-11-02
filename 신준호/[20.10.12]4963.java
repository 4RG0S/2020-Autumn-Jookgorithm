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

        while(!(input = br.readLine()).equals("0 0")) {
            tokens = input.split(" ");
            int w = Integer.parseInt(tokens[0]);
            int h = Integer.parseInt(tokens[1]);
            int[][] map = new int[h][w];

            for(int i = 0; i < h; i++) {
                tokens = br.readLine().split(" ");
                for(int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(tokens[j]);
            }

            System.out.println(island(map));
        }

    }

    public static int island(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        int cnt = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    flipland(map, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void flipland(int[][] map, int row, int col, boolean[][] visited) {
        int[][] dxy = { {-1, -1}, {-1, 0}, {-1, 1},
                        {0, -1}, {0, 0}, {0, 1},
                        {1, -1}, {1, 0}, {1, 1} };

        visited[row][col] = true;
        for(int i = 0; i < dxy.length; i++) {
            int dr = row + dxy[i][0];
            int dc = col + dxy[i][1];

            if(0 <= dr && dr < map.length && 0 <= dc && dc < map[0].length) {
                if(!visited[dr][dc] && map[dr][dc] == 1) flipland(map, dr, dc, visited);
            }
        }

    }


}
