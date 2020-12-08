import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 3;
        if(n>1) dp[2] = 7;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-2]%9901+(dp[i-1]*2)%9901;
        }
        System.out.println(dp[n]%9901);
    }

}