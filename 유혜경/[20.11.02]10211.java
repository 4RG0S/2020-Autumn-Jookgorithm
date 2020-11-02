import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n+1];
            int[] sum = new int[n+1];
            sum[0] = arr[0] = 0;
            for(int j = 1; j <= n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum[j] += sum[j-1] + arr[j];
            }
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= n; j++){
                max = Math.max(max, sum[j]);
                for(int k = 1; k < j; k++){
                    max = Math.max(max, sum[j]-sum[k]);
                }
            }
            System.out.println(max);
        }
    }
}