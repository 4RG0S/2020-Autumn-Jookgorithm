package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_4386 {
	
	static int parent[];
	
	static class Node implements Comparable<Node> {
		int a, b;
		double c;
		public Node(int a, int b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			if(this.c > o.c)
				return 1;
			else
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
		if(aRoot != bRoot)
			parent[aRoot] = bRoot;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		double data[][] = new double[N+1][2];
		double result = 0;
		for(int i=1;i<=N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			data[i][0] = Double.parseDouble(line.nextToken());
			data[i][1] = Double.parseDouble(line.nextToken());
			parent[i] = i;
		}
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				q.add(new Node(i, j, Math.sqrt(Math.pow(Math.abs(data[i][0] - data[j][0]), 2) + Math.pow(Math.abs(data[i][1] - data[j][1]), 2))));
			}
		}
		while(!q.isEmpty()) {
			Node temp = q.poll();
			//System.out.println("Temp :" + temp.a + " " + temp.b + " " + temp.c);
			if(find(temp.a) == find(temp.b)) {
				continue;
			}
			union(temp.a, temp.b);
			result += temp.c;
		}
		System.out.println(result);
	}

}
