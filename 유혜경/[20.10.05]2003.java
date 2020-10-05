import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int sum = 0, cnt = 0;
        for(int i = 0; i < n; i++){
            sum = arr[i];
            if(sum == m) cnt++;
            else{
                for(int j = i+1; j < n; j++){
                    sum += arr[j];
                    if(sum == m) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}