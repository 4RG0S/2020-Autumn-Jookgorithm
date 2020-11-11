package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class November_06_1717 {
	
	static int parent[];
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		parent[find(a)] = b;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(line.nextToken());
		int m = Integer.parseInt(line.nextToken());
		
		parent = new int[n+1];
		for(int i=0;i<=n;i++) {
			parent[i] = i;
		}
		for(int i=0;i<m;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int val = Integer.parseInt(line.nextToken());
			int a = Integer.parseInt(line.nextToken());
			int b = Integer.parseInt(line.nextToken());
			if(val == 0) {
				if(find(a) != find(b))
				union(a, b);
			} else if(val == 1) {
				if(find(a) == find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
