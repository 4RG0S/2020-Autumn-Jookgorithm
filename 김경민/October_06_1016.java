package October;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class October_06_1016 {

	static boolean isPrime(long n) {
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long min = scan.nextLong();
		long max = scan.nextLong();
		long distance = max - min;
		boolean nn[] = new boolean[(int) distance + 1];
		ArrayList<Long> list = new ArrayList<>();

		for (long i = 2; i <= Math.sqrt(max) + 1; i++) {
			if (isPrime(i)) {
				list.add(i * i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			long shortest;
			if(min % list.get(i) == 0)
				shortest = min;
			else {
				shortest = list.get(i) * (min / list.get(i)) + list.get(i);
			}
			for (long index = shortest; index <= max; index += list.get(i)) {
				long in = index - min;
				nn[(int) in] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < nn.length; i++) {
			if(nn[i])
				count++;
		}
		System.out.println(distance + 1 - count);

	}

}
