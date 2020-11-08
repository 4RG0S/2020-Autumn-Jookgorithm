package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_04_16398 {
	
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
		parent[aRoot] = bRoot;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q = new PriorityQueue<>();
		long result = 0;
		int N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=0;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(line.nextToken());
				if(j > i)
					q.add(new Node(i+1, j+1, num));
			}
			parent[i+1] = i+1;
		}
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(find(temp.a) == find(temp.b))
				continue;
			union(temp.a, temp.b);
			result += temp.c;
		}
		System.out.println(result);
		
	}

}
