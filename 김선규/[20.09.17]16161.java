package Baekjoon.solve_15000;

import java.util.*;

public class Baekjoon16161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 1;
		for(int i = 0, j = 0; i < n-1; i++) {
			if(arr[i] > arr[i+1]) {
				max = Math.max(max, palindrome(Arrays.copyOfRange(arr, j , 2*i-j+1)));
				j = i+1;
			}else if(arr[i] == arr[i+1]) {
				max = Math.max(max, palindrome(Arrays.copyOfRange(arr, j , 2*i-j+2)));
				j = i+1;
			}
		}
		
		System.out.print(max);
	}
	
	public static int palindrome(int[] s) {
		int left = (s.length-1)/2, right = (s.length)/2, size = 0;
		if(left == right) {
			size++;
			left--;
			right++;
		}
		while(left >= 0 && right < s.length) {
			if(s[left] == s[right]) {
				size += 2;
			}else {
				return size;
			}
			left--;
			right++;
		}
		return size;
	}
}
