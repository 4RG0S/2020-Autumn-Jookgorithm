package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_1647 {
	
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
			return this.c - o.c;
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
			parent[aRoot] = bRoot;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Node> q = new PriorityQueue<>();
		PriorityQueue<Integer> t = new PriorityQueue<>(Collections.reverseOrder());
		int result = 0;
		
		int N = Integer.valueOf(line.nextToken());
		int M = Integer.valueOf(line.nextToken());
		parent = new int[N+1];
		for(int i=0;i<M;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			q.add(new Node(Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken()), Integer.valueOf(line.nextToken())));
		}
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=0;i<M;i++) {
			Node temp = q.poll();
			if(find(temp.a) == find(temp.b))
				continue;
			union(temp.a, temp.b);
			result += temp.c;
			t.add(temp.c);
		}
		result -= t.poll();
		System.out.println(result);
	}

}
