import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Pair{
        int a;
        int b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static int[][] input;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        input = new int[n][n];
        int maxHeight=0;
        for(int i=0;i<n;i++){
            String inputStr = br.readLine();
            String[] st = inputStr.split(" ");
            for(int j=0;j<n;j++){
                input[i][j] = Integer.parseInt(st[j]);
                if(input[i][j]>maxHeight) maxHeight = input[i][j];
            }
        }

        int answer = 0;
        int sum = 0;
        for(int h=0;h<=maxHeight;h++){
            visited = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && input[i][j]>h){
                        isSafe(i, j, n, h);
                        sum++;
                    }
                }
            }
            if(sum>answer) answer = sum;
            sum = 0;
        }
        System.out.println(answer);
        br.close();
    }
    public static void isSafe(int r, int c, int n, int height){
        visited[r][c] = true;
        q.add(new Pair(r, c));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int a = pair.a;
            int b = pair.b;
            for(int i=0;i<4;i++){
                int nextA = a+direction[i][0];
                int nextB = b+direction[i][1];

                if(nextA>=n || nextA<0 || nextB>=n || nextB<0) continue;

                if(!visited[nextA][nextB] && input[nextA][nextB]>height){
                    q.add(new Pair(nextA, nextB));
                    visited[nextA][nextB] = true;
                }
            }

        }
    }
}
