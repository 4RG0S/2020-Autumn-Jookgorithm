import java.util.Scanner;
	
public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = scan.nextInt();
		}
		int max_value;
		if(N>=1) {
		dp[1] = arr[1];
		}
		if(N>=2) {
		dp[2] = arr[1]+arr[2];
		}
		if(N>=3) {
		max_value = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		dp[3] = Math.max(dp[2], max_value);
		}
		if(N>=4) {
			for(int k = 4; k<=N; k++) {
				max_value = Math.max(dp[k-2]+arr[k], dp[k-3]+arr[k-1]+arr[k]);
				dp[k] = Math.max(dp[k-1], max_value);
			}
		}
		System.out.println(dp[N]);
		scan.close();
	}
}