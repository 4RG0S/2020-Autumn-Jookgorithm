package October;

import java.util.Scanner;

public class October_07_1806 {
	
	static int arr[];
	static int S;
	
	static boolean is_range(int from, int to) {
		if (arr[to] - arr[from - 1] >= S)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int min = Integer.MAX_VALUE;
		S = scan.nextInt();
		arr = new int[N + 1];
		scan.nextLine();
		String[] split = scan.nextLine().split(" ");
		arr[0] = 0;
		for(int i=1;i<=split.length;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(split[i - 1]);
		}
		for(int i=1;i<=N;i++) {
			int start = i;
			int end = N + 1;
			int middle = (start + end) / 2;
			if(is_range(i, end - 1)) {
				while(true) {
					if(is_range(i, middle) && !is_range(i, middle - 1))
						break;
					if(is_range(i, middle)) {
						end = middle;
						middle = (start + end) / 2;
					}
					else if(!is_range(i, middle)) {
						start = middle;
						middle = (start + end) / 2;
					}
				}
			} else
				continue;
			
			//System.out.println(i + " " + middle);
			if(min > middle - i + 1)
				min = middle - i + 1;
		}
		if(min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(0);
		
	}

}
