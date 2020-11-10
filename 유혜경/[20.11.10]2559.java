import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        sum[0] = 0;
        arr[1] = scanner.nextInt();
        sum[1] = arr[1];
        for(int i = 2; i <= n; i++) {
            arr[i] = scanner.nextInt();
            sum[i] = arr[i] + sum[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++){
            max = Math.max(max, sum[i] - sum[i-k]);
        }
        System.out.println(max);
    }
}