package September;

import java.math.BigInteger;
import java.util.Scanner;

public class September_18_16282 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		BigInteger input = new BigInteger(line);
		int count = 0;
		input = input.add(new BigInteger("1"));
		System.out.println(input.toString());
		while(!input.toString().equals("1"))
		{
			input = input.divide(new BigInteger("2"));
			System.out.println(input.toString());
			count++;
		}
		System.out.println(count);
	}

}
