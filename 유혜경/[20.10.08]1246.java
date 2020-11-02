import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cost = new int[m];
        for(int i = 0; i < m; i++){
            cost[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cost);
        int max = 0;
        int retCost = 0;
        for(int i = 0; i < m; i++){
            int tmp;
            if((m-i) <= n) tmp = m-i;
            else tmp = n;
            if(max < cost[i]*tmp){
                max = cost[i]*tmp;
                retCost = cost[i];
            }
        }
        System.out.println(retCost+ " " + max);
    }
}