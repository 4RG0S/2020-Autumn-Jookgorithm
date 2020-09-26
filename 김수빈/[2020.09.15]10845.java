import java.util.*;
import java.util.Scanner;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new LinkedList<Integer>();
		int N = scan.nextInt();
		for(int i = 0; i<N+1; i++) {
			String[] s = scan.nextLine().split(" ");
			if(s[0].equals("push")) {
			    list.add(Integer.parseInt(s[1]));
			}
			if(s[0].equals("front")) {
				if(list.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(list.get(0));
				}
			}
			if(s[0].equals("back")) {
				if(list.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(list.get(list.size()-1));
				}
			}
			if(s[0].equals("size")) {
				System.out.println(list.size());
			}
			if(s[0].equals("empty")) {
				if(list.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
			if(s[0].equals("pop")) {
				if(list.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(list.remove(0));
				}
			}
		}
		scan.close();
	}
}