package September;

import java.math.BigInteger;
import java.util.Scanner;

public class September_17_17520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		BigInteger result = new BigInteger("2");
		BigInteger mod = new BigInteger("16769023");
		result = result.pow((n+1)/2);
		result = result.mod(mod);
		System.out.println(result);
	}

}
