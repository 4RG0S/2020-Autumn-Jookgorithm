import java.util.*;

public class Main {
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String swapint;
		String swapString;
		String[][] arr = new String[N][2];
		for(int i = 0; i<N; i++) {
			arr[i][0] = scan.next();
			arr[i][1] = scan.next();
		}
		Arrays.sort(arr, new Comparator<String []>() {
			public int compare(String [] o1, String [] o2) {
				if(Integer.parseInt(o1[0]) > Integer.parseInt(o2[0]))
					return 1;
				else if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
					return 0;
				}else {
					return -1;
				}	
			}
		});
		for(int h = 0; h<N; h++) {
			System.out.println(arr[h][0]+" "+arr[h][1]);
		}
	}	

}
