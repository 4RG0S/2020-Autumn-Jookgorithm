import java.util.*;

public class Main 
{
	public static int N, M;
	public static int[] Narr;
	public static int[] Marr;
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
    	  
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		Narr = new int[N];		
		Marr = new int[M];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++)
		{
			Narr[i] = scan.nextInt();
		}
		Arrays.sort(Narr);

		dfs(0, 0);
		System.out.print(sb);
    }
      
	public static void dfs(int check, int depth)
    {
		if(depth == M)
		{
			for(int i=0; i<M; i++)
			{
				sb.append(Marr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=check; i<N; i++)
		{	
			if(visit[i] == false)
			{
				visit[i] = true;
				Marr[depth] = Narr[i];
				dfs(i, depth+1);
				
				visit[i] = false;
			}
			
		}
    }
}
