package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class November_05_8012 {
	
	static List<List<Integer>> list = new ArrayList<>();
	static int parent[][];
	static int dep[];
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
		for(int j=1;j<=20;j++) {
			for(int i=1;i<dep.length;i++) {
				parent[i][j] = parent[parent[i][j-1]][j-1];
			}
		}
	}
	
	static int lca(int a, int b) {
		int len = 0;
		if(dep[a] > dep[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for(int i=20;i>=0;i--) {
			if(dep[parent[b][i]] >= dep[a]) {
				if(parent[b][i] != 0) {
					len += Math.pow(2, i);
					b = parent[b][i];
				}
			}
		}
		if(a == b)
			return len;
		for(int i=20;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				len += 2 * Math.pow(2, i);
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return len + 2;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N+1][21];
		visit = new boolean[N+1];
		dep = new int[N+1];
		int result = 0;
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=1;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		dfs(1, 0);
		f();
		int M = Integer.parseInt(br.readLine());
		int mem = 1;
		for(int i=0;i<M;i++) {
			int input = Integer.parseInt(br.readLine());
			result += lca(mem, input);
			mem = input;
		}
		System.out.println(result);
	}

}
