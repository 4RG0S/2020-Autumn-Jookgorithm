import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] arr =  new double[n];
        double[] mul = new double[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextDouble();
        mul[0] = arr[0];
        double max = mul[0];
        for(int i = 1; i < n; i++){
            mul[i] = Math.max(mul[i-1]*arr[i], arr[i]);
            max = Math.max(mul[i], max);
        }
        System.out.println(String.format("%.3f", max));
    }
}