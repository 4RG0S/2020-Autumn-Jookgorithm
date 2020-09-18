package September;

import java.math.BigInteger;
import java.util.Scanner;

public class September_17_17521 {
	
	static BigInteger W;
	static BigInteger count;
	static int coin[];
	
	static void buy(int day) {
		count = count.add(W.divide(new BigInteger(Integer.toString(coin[day]))));
		W = W.mod(new BigInteger(Integer.toString(coin[day])));
	}
	
	static void sell(int day) {
		W = W.add(count.multiply(new BigInteger(Integer.toString(coin[day]))));
		count = new BigInteger("0");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String split[] = line.split(" ");
		int n = Integer.parseInt(split[0]);
		W = new BigInteger(split[1]);
		count = new BigInteger("0");
		coin = new int[n];
		for(int i=0;i<n;i++)
		{
			coin[i] = scan.nextInt();
		}
		for(int i=0;i<n - 1;i++)
		{
			if(coin[i+1] - coin[i] > 0)
				buy(i);
			if(coin[i+1] - coin[i] < 0)
				sell(i);
			//System.out.println(W);
		}
		sell(n - 1);
		System.out.println(W);
	}

}
