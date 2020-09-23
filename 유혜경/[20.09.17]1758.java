import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tip = new int[n+1];
        for(int i = 1; i <= n; i++)
            tip[i] = Integer.parseInt(br.readLine());
        Arrays.sort(tip);
        long sum = 0;
        for(int i = 1; i <= n; i++){
            if((tip[n - i + 1] - (i - 1)) < 0) break;
            else sum += tip[n - i + 1] - (i - 1);
        }
        System.out.println(sum);
    }
}