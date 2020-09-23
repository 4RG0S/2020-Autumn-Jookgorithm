package Baekjoon.solve_01000;

import java.util.*;

public class Baekjoon1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int[] arr = new int[50];
		int i = 0, j = 0, k = 0;
		for(; i < s.length(); i++) {
			if(s.charAt(i) == '-') {
				arr[k] += Integer.parseInt(s.substring(j, i));
				j = i+1;
				k++;
			}else if(s.charAt(i) == '+') {
				arr[k] += Integer.parseInt(s.substring(j, i));
				j = i+1;
			}
		}
		arr[k] += Integer.parseInt(s.substring(j, i));
		
		int ans = arr[0];
		for(i = 1; i < 50; i++) {
			ans -= arr[i];
		}
		System.out.print(ans);

	}
}
