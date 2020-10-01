package Baekjoon.solve_10000;

import java.util.Scanner;

public class Baekjoon14916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int c = 0;
		
		if(n == 1 | n == 3) {
			System.out.print(-1);
			System.exit(0);
		}
		
		c = n/5;
		n %= 5;
		
		if(n%2 == 1) {
			n += 5;
			c--;
		}
		c += n/2;
		n %= 2;
		System.out.print(c);
	}
}
