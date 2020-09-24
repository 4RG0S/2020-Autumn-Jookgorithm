import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] arr = new int[T];
		for(int i = 0; i<T;i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int num = 0;
		for(int j = 0; j<T; j++) {
			for(int h = 0; h<T-j;h++) {
				num += arr[h];
			}
		}
		System.out.println(num);
		scan.close();
	}
}