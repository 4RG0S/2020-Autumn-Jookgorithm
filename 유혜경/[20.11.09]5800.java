import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(int i = 1; i <= k; i++){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = scanner.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("Class "+i);
            int gap = Integer.MIN_VALUE;
            for(int j = 1; j < n; j++) gap = Math.max(gap, arr[j] - arr[j-1]);
            System.out.println("Max "+arr[n-1]+", Min "+arr[0]+", Largest gap "+ gap);
        }
    }
}