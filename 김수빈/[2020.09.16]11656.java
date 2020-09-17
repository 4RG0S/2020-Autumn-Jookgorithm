import java.util.*;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
 		String str = scan.next();
 		List<String> list = new ArrayList<String>();
 		for(int a = 0; a<str.length(); a++) {
 			list.add(str.substring(a,str.length()));
 		}
 		Collections.sort(list);
 		for(String s : list) {
 			System.out.println(s);
 		}
		scan.close();
	}
}