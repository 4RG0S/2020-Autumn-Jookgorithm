package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class November_04_11437 {
	
	static int depth[];
	static int parent[][];
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visited[];
	
	static void dfs(int here, int dep) {
		visited[here] = true;
		depth[here] = dep;
		for(int there : list.get(here)) {
			if(visited[there])
				continue;
			parent[there][0] = here;
			dfs(there, dep + 1);
		}
	}
	
	static void f() {
		for(int i=1;i<20;i++) {
			for(int j=1;j<depth.length;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	static int lca(int a, int b) {
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for(int i=19;i>=0;i--) {
			if(depth[a] <= depth[parent[b][i]]) {
				if(parent[b][i] != 0)
					b = parent[b][i];
			}
		}
		if(a == b)
			return a;
		//System.out.println(a + " " + b);
		for(int i=19;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		//System.out.println(a + " " + b);
		return parent[a][0];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1][20];
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=1;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		dfs(1, 0);
		f();
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			System.out.println(lca(from, to));
		}
	}

}
