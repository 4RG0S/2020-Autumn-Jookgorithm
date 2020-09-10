import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] input = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                input[i][j] = scan.nextInt();
            }
        }
        long[][] dp = new long[n][n];

        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int jump = input[i][j];

                int nexti = i+jump;
                int nextj = j+jump;

                if(jump>0) {
                    if (nexti < n) {
                        dp[nexti][j] += dp[i][j];
                    }
                    if (nextj < n) {
                        dp[i][nextj] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}