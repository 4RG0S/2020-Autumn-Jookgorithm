import java.util.*;

public class Main 
{
	public static int N, M;
	public static int[] elements;
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
    	  
		N = scan.nextInt();
		M = scan.nextInt();
		elements = new int[M];
    	  
		dfs(1, 0);
    }
      
	public static void dfs(int A, int B)
    {
		if(B == M)
		{
			for(int val : elements)
			{
				System.out.print(val + " ");				
			}
			System.out.println();
			return;
		}
		
		for(int i=A; i<=N; i++)
		{
			elements[B] = i;
			dfs(i+1, B+1);
		}
    }
}
