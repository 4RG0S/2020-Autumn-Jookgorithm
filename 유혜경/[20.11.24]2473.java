import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] sol = new long[n];
        for(int i = 0; i < n; i++)
            sol[i] = scan.nextLong();
        Arrays.sort(sol);
        long min = Long.MAX_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 1;
        for(int i = 0; i < n; i++){
            int m = i+1;
            int j = n-1;
            while(true){
                if(j <= m) break;
                long sum = sol[i] + sol[m] + sol[j];
                if(sum == 0){
                    left = i; mid = m; right = j;
                    min = 0;
                    break;
                }
                if(min > Math.abs(sum)){
                    left = i; mid = m; right = j;
                    min = Math.abs(sum);
                }
                if(sum < 0) m++;
                if(sum > 0) j--;
            }
            if(min == 0) break;
        }
        System.out.println(sol[left] + " " + sol[mid] + " " + sol[right]);
    }
}