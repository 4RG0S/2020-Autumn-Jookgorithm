package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_1922 {
	
	static int parent[];
	
	static class Node implements Comparable<Node> {
		int a, b, c;
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			if(this.c > o.c)
				return 1;
			return -1;
		}
		
	}
	
	static int find(int a) {
		if(a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		}
		else
			return;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<M;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			q.add(new Node(Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken())));
		}
		parent = new int[N+1];
		for(int i=1;i<N;i++) {
			parent[i] = i;
		}
		for(int i=0;i<M;i++) {
			Node temp = q.poll();
			int aRoot = find(temp.a);
			int bRoot = find(temp.b);
			if(aRoot == bRoot)
				continue;
			union(temp.a, temp.b);
			result += temp.c;
		}
		System.out.println(result);
	}

}
