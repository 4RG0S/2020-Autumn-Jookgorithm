import sun.nio.cs.ext.MacHebrew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] loc = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        loc[0] = 0;
        for(int i = 1; i <= n; i++)
            loc[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(loc);
        int zero = 0;
        for(int i = 0; i <= n; i++){
            if(loc[i] == 0) {
                zero = i;
                break;
            }
        }
        int i, sum = 0;
        for(i = 0; i < zero; i += m){
            sum += Math.abs(loc[i])*2;
        }
        for(i = n; i > zero; i -= m){
            sum += Math.abs(loc[i])*2;
        }
        sum -= Math.max(Math.abs(loc[0]), Math.abs(loc[n]));
        System.out.println(sum);
    }
}