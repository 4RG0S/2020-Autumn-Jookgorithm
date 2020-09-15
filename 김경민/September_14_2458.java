package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class September_14_2458 {
	
	static List<List<Integer>> big = new ArrayList<>();
	static List<List<Integer>> small = new ArrayList<>();
	static int count = 0;
	static int visit = 0;
	static boolean is_visit[];
	
	static void dfs_big(int index)
	{
		is_visit[index] = true;
		visit++;
		for(int i=0;i<big.get(index).size();i++)
		{
			int to = big.get(index).get(i);
			if(!is_visit[to])
				dfs_big(to);
		}
	}
	
	static void dfs_small(int index)
	{
		is_visit[index] = true;
		visit++;
		for(int i=0;i<small.get(index).size();i++)
		{
			int to = small.get(index).get(i);
			if(!is_visit[to])
				dfs_small(to);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		
		for(int i=0;i<N + 1;i++)
		{
			big.add(new ArrayList<>());
			small.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++)
		{
			line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			
			big.get(from).add(to);
			small.get(to).add(from);
		}
		for(int i=1;i<=N;i++)
		{
			visit = 0;
			is_visit = new boolean[N+1];
			dfs_big(i);
			dfs_small(i);
			if(visit == N + 1)
				count++;
		}
		System.out.println(count);
	}

}
