package October;

import java.util.HashMap;
import java.util.Scanner;

public class October_07_9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		int arr[][] = new int[1001][1001];
		int i,k;
		int len1 = s1.length();
		int len2 = s2.length();
		for (i = 1; i <= len2; i++) {
			for (k = 1; k <= len1; k++) {
				if (s2.charAt(i - 1) == s1.charAt(k - 1))
					arr[i][k] = arr[i - 1][k - 1] + 1;
				else
					arr[i][k] = (arr[i - 1][k] > arr[i][k - 1]) ? arr[i - 1][k] : arr[i][k - 1];
			}
		}
		System.out.println(arr[len2][len1]);
	}

}
