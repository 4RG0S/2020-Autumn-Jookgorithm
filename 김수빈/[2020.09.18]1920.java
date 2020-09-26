import java.util.*;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Set<Integer> list = new HashSet<Integer>();
		for( int i = 0; i<N; i++) {
			list.add(scan.nextInt());
		}
		int M = scan.nextInt();
		int[] arr = new int[M];
		for(int j = 0; j<M;j++) {
			arr[j] = scan.nextInt();
		}
		for(int h = 0; h<M; h++) {
			if(!list.add(arr[h])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		scan.close();
	}
}
