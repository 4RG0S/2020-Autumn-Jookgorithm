package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_1197 {
	
	static int parent[];
	
	static class Node implements Comparable<Node>{
		int s, d, v;
		public Node(int s, int d, int v) {
			this.s = s;
			this.d = d;
			this.v = v;
		}
		@Override
		public int compareTo(Node o) {
			if(this.v > o.v)
				return 1;
			else if(this.v < o.v)
				return -1;
			else
				return 0;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return;
		else
			parent[aRoot] = b;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q = new PriorityQueue<>();
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int E = Integer.valueOf(line.nextToken());
		int V = Integer.valueOf(line.nextToken());
		int result = 0;
		parent = new int[E+1];
		for(int i=0;i<V;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			q.add(new Node(Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken())));
		}
		for(int i=1;i<=E;i++) {
			parent[i] = i;
		}
		for(int i=0;i<V;i++) {
			Node temp = q.poll();
			int sRoot = find(temp.s);
			int dRoot = find(temp.d);
			if(sRoot == dRoot)
				continue;
			union(temp.s, temp.d);
			result += temp.v;
		}
		System.out.println(result);
	}

}
