import java.util.*;


public class Main {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		char[] ch = scan.next().toCharArray();
		for(char a : ch) {
	         Integer swap = map.get(String.valueOf(a));
	         map.put(String.valueOf(a), (swap==null)? 1:swap+1);
	    }
		for(char i = 'a'; i<='z'; i++) {
			if(map.get(String.valueOf(i))==null) {
				System.out.print(0+" ");
			}else {
				System.out.print(map.get(String.valueOf(i))+" ");
			}
		}
		scan.close();
	}
}