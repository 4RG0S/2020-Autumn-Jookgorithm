import java.util.Scanner;
	
public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] ch = {' '};
		while(scan.hasNextLine()) {
			ch = scan.nextLine().toCharArray();
			int[] arr = new int[4];
			for(int j = 0; j<ch.length;j++) {
				if(ch[j]>='a'&&ch[j]<='z') {
					arr[0]++;
				}
				else if(ch[j]>='A'&& ch[j]<='Z') {
					arr[1]++;
				}
				else if(ch[j]==' ') {
					arr[2]++;
				}else {
					arr[3]++;
				}
			}
			System.out.println(arr[0]+" "+arr[1]+" "+arr[3]+" "+arr[2]);
		}
		scan.close();
	}
}