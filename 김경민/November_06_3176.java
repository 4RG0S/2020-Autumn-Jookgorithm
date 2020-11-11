package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class November_06_3176 {
	
	static int N;
	static int parent[][];
	static int min[][];
	static int max[][];
	static int depth[];
	static boolean visit[];
	static List<List<Node>> list = new ArrayList<>();
	
	static class Node {
		int a, b, c;
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static void dfs(int here, int dep) {
		visit[here] = true;
		depth[here] = dep;
		for(int i=0;i<list.get(here).size();i++) {
			Node temp = list.get(here).get(i);
			if(visit[temp.b])
				continue;
			parent[temp.b][0] = here;
			max[temp.b][0] = temp.c;
			min[temp.b][0] = temp.c;
			dfs(temp.b, dep + 1);
		}
	}
	
	static void f() {
		for(int j=1;j<20;j++) {
			for(int i=1;i<=N;i++) {
				parent[i][j] = parent[parent[i][j-1]][j-1];
				min[i][j] = Integer.min(min[i][j-1], min[parent[i][j-1]][j-1]);
				max[i][j] = Integer.max(max[i][j-1], max[parent[i][j-1]][j-1]);
			}
		}
	}
	
	static void lca(int a, int b) {
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int min_result = Integer.MAX_VALUE;
		int max_result = Integer.MIN_VALUE;
		for(int i=19;i>=0;i--) {
			if(depth[a] <= depth[parent[b][i]]) {
				if(parent[b][i] != 0) {
					max_result = (max_result < max[b][i]) ? max[b][i] : max_result;
					min_result = (min_result > min[b][i] && min[b][i] != 0) ? min[b][i] : min_result;
					b = parent[b][i];
				}
			}
		}
		if(a == b) {
			System.out.println(min_result + " " + max_result);
			return;
		}
		//System.out.println("Middle : " + min_result + " " + max_result);

		for(int i=19;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				max_result = (max_result < max[a][i]) ? max[a][i] : max_result;
				min_result = (min_result > min[a][i] && min[a][i] != 0) ? min[a][i] : min_result;
				max_result = (max_result < max[b][i]) ? max[b][i] : max_result;
				min_result = (min_result > min[b][i] && min[b][i] != 0) ? min[b][i] : min_result;
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		max_result = (max_result < max[a][0]) ? max[a][0] : max_result;
		min_result = (min_result > min[a][0] && min[a][0] != 0) ? min[a][0] : min_result;
		max_result = (max_result < max[b][0]) ? max[b][0] : max_result;
		min_result = (min_result > min[b][0] && min[b][0] != 0) ? min[b][0] : min_result;
		System.out.println(min_result + " " + max_result);
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1][20];
		min = new int[N+1][20];
		max = new int[N+1][20];
		depth = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=1;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			int val = Integer.parseInt(line.nextToken());
			list.get(from).add(new Node(from, to, val));
			list.get(to).add(new Node(to, from, val));
		}
		dfs(1, 0);
		f();
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			lca(from, to);
		}
		//System.out.println(min[4][0]);
	}

}
