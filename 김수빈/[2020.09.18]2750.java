import java.util.*;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for( int i = 0; i<N; i++) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
	    for(int a : list) {
	    	System.out.println(a);
	    }
		scan.close();
	}
}
