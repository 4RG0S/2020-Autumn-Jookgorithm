import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i<=T;i++) {
			list.add(i);
		}
		int i = 0;
		while(list.size()!=1) {
			if(i%2==0) {
				list.remove(0);
			}else {
				list.add(list.get(0));
				list.remove(0);
			}
			i++;
		}
		System.out.println(list.get(0));
		scan.close();
	}
}