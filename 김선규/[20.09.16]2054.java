package Baekjoon.solve_02000;

import java.util.*;

public class Baekjoon2054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int n = 2*s.length()-1;
		char[] arr = new char[n];
		for(int i = 0; i < s.length(); i++) {
			arr[2*i] = s.charAt(i);
		}
		if(s.equals("2000")) {
			System.exit(0);
		}
		makeExpression(arr, n , 1);
	}
	
	public static void makeExpression(char[] arr, int n, int m) {
		if(m >= n) {
			if(correct(arr,n)) {
				String s = new String(arr);
				s = s.replaceAll(" ", "");
				System.out.println(s);
			}
			return;
		}
		arr[m] = '*'; makeExpression(arr, n, m+2);
		arr[m] = '+'; makeExpression(arr, n, m+2);
		arr[m] = '-'; makeExpression(arr, n, m+2);
		arr[m] = ' '; makeExpression(arr, n, m+2);
	}
	
	public static boolean correct(char[] arr, int n) {
		char c = arr[0];
		for(int i = 1; i <= n-1; i += 2) {
			if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*') {
				c = arr[i+1];
			}else {
				if(c == '0') {
					return false;
				}
			}
		}
		return (cal(arr, n) == 2000);
	}
	
	public static int cal(char[] arr, int n) {
		String s = "";
		ArrayList<String> li1 = new ArrayList<>(); 
		for(int i = 0; i < n; i++) {
			if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*') {
				li1.add(s);
				li1.add(""+arr[i]);
				s = "";
			}else if(arr[i] != ' ') {
				s += arr[i];
			}
		}
		li1.add(s);
		
		ArrayList<String> li2 = new ArrayList<>(); 
		Stack<String> st = new Stack<>();
		
		for(int i = 0; i < li1.size(); i++) {
			if(li1.get(i).equals("+") || li1.get(i).equals("-")) {
				while(!st.isEmpty() && (st.peek().equals("+") || st.peek().equals("-") || st.peek().equals("*"))) {
					li2.add(st.pop());
				}
				st.push(li1.get(i));
			}else if(li1.get(i).equals("*")) {
				while(!st.isEmpty() && st.peek().equals("*")) {
					li2.add(st.pop());
				}
				st.push(li1.get(i));
			}else {
				li2.add(li1.get(i));
			}
		}
		while(!st.empty()) {
			li2.add(st.pop());
		}
		
		Stack<Integer> sta = new Stack<>();
		for(int i = 0; i < li2.size(); i++) {
			if(li2.get(i).equals("+") || li2.get(i).equals("-") || li2.get(i).equals("*")) {
				int b = sta.pop(), a = sta.pop();
				if(li2.get(i).equals("+")) {
					sta.push(a + b);
				}else if(li2.get(i).equals("-")) {
					sta.push(a - b);
				}else {
					sta.push(a * b);
				}
			}else {
				sta.push(Integer.parseInt(li2.get(i)));
			}
		}
		return sta.pop();
	}
}
