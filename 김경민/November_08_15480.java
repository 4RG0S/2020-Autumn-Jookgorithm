package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class November_08_15480 {
	
	static int parent[][];
	static int dep[];
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	
	
	static void dfs(int here, int depth) {
		visit[here] = true;
		dep[here] = depth;
		for(int there : list.get(here)) {
			if(visit[there])
				continue;
			parent[there][0] = here;
			dfs(there, depth + 1);
		}
	}
	
	static void f() {
		for(int i=1;i<20;i++) {
			for(int j=1;j<parent.length;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	static int lca(int a, int b) {
		if(dep[a] > dep[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for(int i=19;i>=0;i--) {
			if(dep[a] <= dep[parent[b][i]]) {
				if(parent[b][i] != 0)
					b = parent[b][i];
			}
		}
		if(a == b)
			return a;
		for(int i=19;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N+1][20];
		dep = new int[N+1];
		visit = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
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
			int r = Integer.parseInt(line.nextToken());
			int u = Integer.parseInt(line.nextToken());
			int v = Integer.parseInt(line.nextToken());
			int ru = lca(r, u);
			int rv = lca(r, v);
			int uv = lca(u, v);
			if(Integer.max(dep[ru], Integer.max(dep[rv], dep[uv])) == dep[ru]) {
				System.out.println(ru);
			} else if(Integer.max(dep[ru], Integer.max(dep[rv], dep[uv])) == dep[rv]) {
				System.out.println(rv);
			} else if(Integer.max(dep[ru], Integer.max(dep[rv], dep[uv])) == dep[uv]) {
				System.out.println(uv);
			}
		}
		
	}

}
