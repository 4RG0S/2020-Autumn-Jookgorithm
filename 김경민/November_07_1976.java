package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class November_07_1976 {
	
	static int parent[];
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot)
			parent[aRoot] = b;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=1;i<=N;i++)
			parent[i] = i;
		
		for(int i=0;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(line.nextToken());
				if(temp == 1)
					union(i+1, j+1);
			}
		}
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		boolean okay = true;
		int root = find(Integer.parseInt(line.nextToken()));
		for(int i=1;i<M;i++) {
			int temp = find(Integer.parseInt(line.nextToken()));
			if(root != temp)
				okay = false;
		}
		if(okay)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
