package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class November_05_1761 {
	
	static class Data {
		int dest, val;
		public Data(int dest, int val) {
			this.dest = dest;
			this.val = val;
		}
	}
	
	static int val[][];
	static int depth[];
	static int parent[][];
	static List<List<Data>> list = new ArrayList<>();
	static boolean visited[];
	
	static void dfs(int here, int dep) {
		visited[here] = true;
		depth[here] = dep;
		for(int i=0;i<list.get(here).size();i++) {
			int there = list.get(here).get(i).dest;
			if(visited[there])
				continue;
			parent[there][0] = here;
			val[there][0] = list.get(here).get(i).val;
			dfs(there, dep + 1);
		}
	}
	
	static void f() {
		for(int i=1;i<20;i++) {
			for(int j=1;j<depth.length;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
				val[j][i] = val[j][i - 1] + val[parent[j][i-1]][i-1];
				//System.out.print(val[j][i-1] + " ");

			}
			//System.out.println();
		}
	}
	
	static int lca(int a, int b) {
		int result = 0;
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for(int i=19;i>=0;i--) {
			if(depth[a] <= depth[parent[b][i]]) {
				if(parent[b][i] != 0) {
					result += val[b][i];
					b = parent[b][i];
				}
			}
		}
		//System.out.println(result + "a");
		if(a == b)
			return result;
		//System.out.println(a + " " + b);
		for(int i=19;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				result = result + val[a][i] + val[b][i];
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		//System.out.println(a + " " + b);
		return result + val[a][0] + val[b][0];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		val = new int[N+1][20];
		visited = new boolean[N+1];
		parent = new int[N+1][20];
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=1;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			int val = Integer.parseInt(line.nextToken());
			list.get(from).add(new Data(to, val));
			list.get(to).add(new Data(from, val));
		}
		dfs(1, 0);
		f();
		//System.out.println(val[6][0]);
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			System.out.println(lca(from, to));
		}
	}

}
