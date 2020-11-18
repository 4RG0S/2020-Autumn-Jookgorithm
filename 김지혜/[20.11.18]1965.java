import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = scan.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++){
                if(input[i]>input[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += 1;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}