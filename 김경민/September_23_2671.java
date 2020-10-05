package September;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class September_23_2671 {
	
	static boolean submarine = false;
	static Matcher matcher;
	
	static void find(Pattern pattern, String buffer)
	{
		//System.out.println(buffer);
		StringBuffer temp = new StringBuffer("");
		if(buffer.length() > 0)
			temp.append(buffer.charAt(0));
		for(int i=1;i<buffer.length();i++)
		{
			temp.append(buffer.charAt(i));
			matcher = pattern.matcher(temp.toString());
			//System.out.println("match" + temp.toString());
			if(matcher.find() && matcher.end() == i+1 && matcher.start() == 0)
			{
				if(buffer.length() == temp.length())
					submarine = true;
				//System.out.println("sub" + buffer.substring(i + 1));
				find(pattern, buffer.substring(i + 1));
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		Pattern pattern = Pattern.compile("^(1000*11*)|(01)$");
		find(pattern, line);
		if(submarine)
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
		
		// 비교 직전에 gc 를 사용해서 garbage collection을 실행하도록 하면 보다 더 정확하게 메모리 소비량을 얻을 수 있다. 
		
	}

}
