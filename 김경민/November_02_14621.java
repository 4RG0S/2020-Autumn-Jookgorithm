package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_14621 {
		
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
				parent[aRoot] = b;
			}
		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Node> q = new PriorityQueue<>();
			int result = 0;
			
			int N = Integer.valueOf(line.nextToken());
			int M = Integer.valueOf(line.nextToken());
			boolean gender[] = new boolean[N+1];
			parent = new int[N+1];

			line = new StringTokenizer(br.readLine(), " ");
			for(int i=1;i<=N;i++) {
				parent[i] = i;
				if(line.nextToken().equals("M"))
					gender[i] = true;
				else
					gender[i] = false;
			}
			for(int i=0;i<M;i++) {
				line = new StringTokenizer(br.readLine(), " ");
				int from = Integer.valueOf(line.nextToken());
				int dest = Integer.valueOf(line.nextToken());
				int val = Integer.valueOf(line.nextToken());
				if(gender[from] ^ gender[dest])
					q.add(new Node(from, dest, val));
			}

			while(!q.isEmpty()) {
				Node temp = q.poll();
				if(find(temp.a) == find(temp.b))
					continue;
				union(temp.a, temp.b);
				result += temp.c;
			}
			boolean made = true;
			int root = find(parent[1]);
			for(int i=2;i<=N;i++) {
				if(find(parent[i]) != root) {
					made = false;
					break;
				}
			}
			if(!made)
				System.out.println(-1);
			else
				System.out.println(result);
		

	}


}