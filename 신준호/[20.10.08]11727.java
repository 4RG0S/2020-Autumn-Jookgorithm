import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        System.out.println(twoN(n));
    }

    public static int twoN(int n) {
        if(n == 0) return 1;

        if(dp[n] != 0) return dp[n];

        int opt = 0;
        if(n >= 2) opt = (opt + twoN(n - 2) * 2) % 10007;
        opt = (opt + twoN(n - 1)) % 10007;

        return dp[n] = opt;


    }



}
