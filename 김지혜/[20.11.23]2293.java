import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i=0;i<n;i++){
            coin[i] = scan.nextInt();
        }
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=k;j++){
                dp[j] = dp[j] + dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}