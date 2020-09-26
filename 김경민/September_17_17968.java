package September;

import java.util.Scanner;

public class September_17_17968 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int result[] = new int[1001];
		result[0] = 1;
		result[1] = 1;
		for(int i=2;i<=1000;i++)
		{
			boolean forbidden[] = new boolean[1000];
			for(int j=0;j<i/2;j++)
			{
				int one = result[i-(j+1)*2];
				int two = result[i-(j+1)];
				if(two + (two - one) > 0)
					forbidden[two + (two - one)] = true;
			}
			for(int j=1;j<=1000;j++)
			{
				if(!forbidden[j])
				{
					result[i] = j;
					break;
				}
			}
		}
		System.out.println(result[n]);
	}

}
