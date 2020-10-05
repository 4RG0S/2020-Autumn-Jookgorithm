package September;

import java.math.BigInteger;
import java.util.Scanner;

public class September_22_10422 {

	static BigInteger facto(int input) {
		if (input == 0 || input == 1)
			return new BigInteger("1");
		return new BigInteger(Integer.toString(input)).multiply(facto(input - 1));
	}

	static BigInteger track(int input) {
		BigInteger temp = new BigInteger("0");
		if (input <= 0)
			return new BigInteger("1");
		else if (input == 1)
			return new BigInteger("2");
		for (int i = 0; i <= input; i++) {
			temp = temp.add(track(input - i - 1).multiply(track(i - 1)));
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BigInteger arr[] = new BigInteger[2501];
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("2");
		arr[2] = new BigInteger("5");
		int n = scan.nextInt();
		for(int i=3;i<=2500;i++)
		{
			BigInteger temp = new BigInteger("0");
			for(int j=0;j<=i;j++)
			{
				if(j != 0 && j != i)
					temp = temp.add(arr[i - j - 1].multiply(arr[j-1]));
				else if(j == i)
				{
					temp = temp.add(arr[j-1]);
				}
				else
					temp = temp.add(arr[i - j - 1]);
			}
			arr[i] = temp;
		}
		for(int i=0;i<n;i++)
		{
			int input = scan.nextInt();
			if(input % 2 == 0)
				System.out.println(arr[input/2 - 1].mod(new BigInteger("1000000007")).toString());
			else
				System.out.println(0);
		}
	}

}
