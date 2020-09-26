import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N!=1) {
			a:for(int i = 2; i<=N; i++) {
				if(N%i==0) {
					System.out.println(i);
					N = N / i;
					break a;
				}
			}
		}
		scan.close();
	}
}
