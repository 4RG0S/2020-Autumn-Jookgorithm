package September;

import java.util.Scanner;

public class September_21_9465 {
	
	static class sticker{
		int none, fir, se;
		public sticker(int none, int fir, int se)
		{
			this.none = none;
			this.fir = fir;
			this.se = se;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++)
		{
			int n = scan.nextInt();
			sticker arr[] = new sticker[n];
			int num[][] = new int[2][n];
			scan.nextLine();
			String fir = scan.nextLine();
			String se = scan.nextLine();
			String split_fir[] = fir.split(" ");
			String split_se[] = se.split(" ");
			for(int j=0;j<n;j++)
			{
				num[0][j] = Integer.parseInt(split_fir[j]);
				num[1][j] = Integer.parseInt(split_se[j]);
			}
			arr[0] = new sticker(0, num[0][0], num[1][0]);
			for(int j=1;j<n;j++)
			{
				arr[j] = new sticker(Integer.max(arr[j-1].fir, Integer.max(arr[j-1].se, arr[j-1].none)), Integer.max(arr[j-1].se + num[0][j], arr[j-1].none + num[0][j]), Integer.max(arr[j-1].fir + num[1][j], arr[j-1].none + num[1][j]));
			}
			System.out.println(Integer.max(arr[n-1].none, Integer.max(arr[n-1].fir, arr[n-1].se)));
		}
	}

}
