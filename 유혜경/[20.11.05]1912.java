import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        sum[0] = arr[0];
        int max = sum[0];
        for(int i = 1; i < n; i++){
            sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
            max = Math.max(sum[i], max);
        }
        System.out.println(max);
    }
}