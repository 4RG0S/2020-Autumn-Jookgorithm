package Baekjoon.solve_01000;

import java.util.Scanner;

public class Baekjoon1769 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		s = func(s, 0);
		if(s.equals("3") || s.equals("6") || s.equals("9")) {
			System.out.print("YES");
		}else {
			System.out.print("NO");
		}
	}
	
	public static String func(String s, int a) {
		
		if(s.length() == 1) {
			System.out.println(a);
			return s;
		}
		
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) -  48;
		}
		
		return func(Integer.toString(sum), a+1);
	}
}
