package September;

import java.util.Scanner;

public class September_25_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N != 1)
		{
			for(int i=2;i<=N;i++)
			{
				if(N % i == 0)
				{
					System.out.println(i);
					N /= i;
					break;
				}
			}
		}
	}

}
