import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] students = new int[n];
            for(int j = 0; j < n; j++)
                students[j] = Integer.parseInt(br.readLine());

            for(int j = 1; j < 1000000; j++) {
                int[] tmp = new int[n];
                int k;
                for(k = 0; k < n; k++)
                    tmp[k] = students[k] % j;

                Arrays.sort(tmp);
                for(k = 0; k < n - 1; k++) {
                    if(tmp[k] == tmp[k+1]) break;
                }

                if(k == n-1) {
                    System.out.println(j);
                    break;
                }
            }

        }

    }


}
