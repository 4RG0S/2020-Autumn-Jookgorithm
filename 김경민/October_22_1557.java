package October;

import java.util.ArrayList;
import java.util.Scanner;

public class October_22_1557 {
	
	static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		ArrayList<Long> list = new ArrayList<>();
		for(int i=1;i<50000;i++) {
			if(isPrime(i)) {
				list.add(((long)i * i));
			}
		}
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.size());
	}

}
