import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] input = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                input[i][j] = scan.nextInt();
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = input[1][1];

        for(int i=1;i<=n;i++){
            dp[1][i] = dp[1][i-1]+input[1][i];
            dp[i][1] = dp[i-1][1]+input[i][1];
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+input[i][j];
            }
        }
        for(int i=0;i<m;i++){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            int sum = dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            System.out.println(sum);

        }
    }

}