import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		System.out.println(check(n));
	}

	public static int check(int n)
	{
		int[] d = new int[1001];
		d[1] = 1;
	    d[2] = 2;

	    for(int i=3; i<=n; i++)
	    {
	    	 d[i] = (d[i-1] + d[i-2]) % 10007;
	    }

		return d[n];
	}
}
