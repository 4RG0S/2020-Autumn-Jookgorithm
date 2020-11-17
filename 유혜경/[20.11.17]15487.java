import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int min = arr[0];
        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;
        for(int i = 1; i < n-2; i++){
            left[i] = Math.max(left[i-1], arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        int max = arr[n-1];
        int[] right = new int[n];
        right[n-1] = Integer.MIN_VALUE;
        for(int i = n-2; i > 1; i--){
            right[i] = Math.max(right[i+1], max - arr[i]);
            max = Math.max(max, arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i < n-1; i++){
            ans = Math.max(ans, left[i] + right[i+1]);
        }
        System.out.println(ans);
    }
}