package September;

import java.util.Scanner;

public class September_17_17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int min = Integer.MAX_VALUE;
		for(int i=(int)Math.sqrt(n);i>=0;i--)
		{
			int temp1 = n - i*i;
			for(int j=(int)Math.sqrt(temp1);j>=0 && i >= j;j--)
			{
				int temp2 = temp1 - j*j;
				for(int k=(int)Math.sqrt(temp2);k>=0 && j >= k;k--)
				{
					int temp3 = temp2 - k*k;
					for(int l=(int)Math.sqrt(temp3);l>=0 && k >= l;l--)
					{
						int temp4 = temp3 - l*l;
						int count = 4;
						if(temp4 == 0)
						{
							if(l == 0)
								count--;
							if(k == 0)
								count--;
							if(j == 0)
								count--;
						}
						if(count < min)
							min = count;
					}
				}
			}
		}
		System.out.println(min);
	}

}
