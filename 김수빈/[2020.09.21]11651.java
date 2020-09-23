import java.util.*;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] xy = new int[n][2];
		for(int i=0; i<n; i++) {
			xy[i][1] = sc.nextInt();
			xy[i][0] = sc.nextInt();
		}
		Arrays.sort(xy, new Comparator<int []>(){
			public int compare(int a[], int b[]) {
				if(a[0] == b[0]) {
					return a[1]-b[1];
				}else {
					return a[0]-b[0];
				}
			}
		});
		for(int i=0; i<n; i++) {
			System.out.println(xy[i][1]+" "+xy[i][0]);
		}
		sc.close();
	}
}