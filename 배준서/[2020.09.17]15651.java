import java.util.*;

public class Main 
{
	public static int N, M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
    	  
		N = scan.nextInt();
		M = scan.nextInt();
		
		arr = new int[M];		
		
		dfs(0);
		System.out.print(sb);
    }
      
	public static void dfs(int depth)
    {
		if(depth == M)
		{
			for(int val : arr)
			{
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++)
		{
			arr[depth] = i;
			dfs(depth+1);
		}
    }
}
