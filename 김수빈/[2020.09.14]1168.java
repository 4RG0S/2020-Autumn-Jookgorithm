import java.util.ArrayList;
import java.util.Scanner;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			list.add(i+1);
		}
		int j = K-1;
		System.out.print("<");
		while(list.size()!=1) {
			System.out.print(list.get(j)+", ");
			list.remove(j);
			j += K-1;
			if(j>list.size()-1) {
				j %= list.size();
			}
		}
		System.out.print(list.get(0)+">");
		scan.close();
	}
}