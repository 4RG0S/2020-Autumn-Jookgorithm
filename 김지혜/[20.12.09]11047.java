import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int money = scan.nextInt();
        int[] coins = new int[N];
        int[] dp = new int[money+1];
        Arrays.fill(dp, money+1);
        for(int i=0;i<N;i++){
            coins[i] = scan.nextInt();
            if(coins[i]<=money) dp[coins[i]] = 1;
        }
        dp[0] = 0;
        for(int i=1;i<=money;i++){
            for(int j=0;j<N;j++){
                if(i>=coins[j]) dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        System.out.println(dp[money]);


    }

}