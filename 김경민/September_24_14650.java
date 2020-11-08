package September;

import java.util.Scanner;

public class September_24_14650 {
	
	static int result = 0;
	
	static void sam(StringBuffer str, int n)
	{
		if(n == 0)
		{
			String calculate = str.toString();
			int count = 0;
			for(int i=0;i<calculate.length();i++)
			{
				count += calculate.charAt(i) - '0';
			}
			if(count % 3 == 0)
				result++;
		}
		else {
			for(int i=0;i<3;i++)
			{
				str.append((i + '0'));
				sam(str, n-1);
				str.deleteCharAt(str.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringBuffer line = new StringBuffer("");
		line.append('1');
		sam(line, n-1);
		line.deleteCharAt(0);
		line.append('2');
		sam(line, n-1);
		System.out.println(result);
	}

}
