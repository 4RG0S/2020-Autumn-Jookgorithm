package September;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class September_29_2644 {
	
	static List<List<Integer>> list = new ArrayList<>();
	static boolean is_visit[];
	static int result = -1;
	
	static void dfs(int here, int find, int count)
	{
		if(here == find)
			result = count;
		for(int i=0;i<list.get(here).size();i++)
		{
			int now = list.get(here).get(i);
			if(!is_visit[now])
			{
				is_visit[now] = true;
				dfs(now, find, count + 1);
				is_visit[now] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++)
		{
			list.add(new ArrayList<>());
		}
		is_visit = new boolean[n];
		int from = scan.nextInt() - 1;
		int to = scan.nextInt() - 1;
		int m = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<m;i++)
		{
			int parent = scan.nextInt() - 1;
			int child = scan.nextInt() - 1;
			list.get(parent).add(child);
			list.get(child).add(parent);
		}
		is_visit[from] = true;
		dfs(from, to, 0);
		System.out.println(result);
	}

}
