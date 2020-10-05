import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		int N = scan.nextInt();
		
		for(int i=0; i<N; i++)
		{
			int input = scan.nextInt();
			set.add(input);
		}
		
		for(int value : set)
		{
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}
}
