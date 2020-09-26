import java.util.*;

	
public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> set= new TreeSet<String>();
		List<String> list = new ArrayList<String>();
		int N = scan.nextInt();
		for(int i = 0; i<N;i++) {
			String s = scan.next();
			set.add(s);
		}
		for(String a : set) {
			list.add(a);
		}
		int num = 0;
		while(num!=51) {
			for(int j = 0; j<list.size();j++) {
				if(num==list.get(j).length()) {
					System.out.println(list.get(j));
				}
			}
			num++;
	    }
		scan.close();
	}
}