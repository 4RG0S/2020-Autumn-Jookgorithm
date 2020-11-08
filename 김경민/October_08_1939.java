package October;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class October_08_1939 {
	
	static boolean okay = false;
	static boolean is_visit[];
	static int N;
	static class bridge {
		int dest, weight;
		public bridge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static List<List<bridge>> list = new ArrayList<>();
	
	static void dfs(int from, int dest, int weight) {
		if(from == dest)
			okay = true;
		for(int i=0;i<list.get(from).size();i++) {
			bridge temp = list.get(from).get(i);
			if(temp.weight >= weight && !is_visit[temp.dest]) {
				is_visit[temp.dest] = true;
				dfs(temp.dest, dest, weight);
			}
		}
	}
	
	static boolean valid(int from, int to, int weight) {
		is_visit = new boolean[N + 1];
		okay = false;
		dfs(from, to, weight);
		return okay;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		int max = 0;
		
		for(int i=0;i<N + 1;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			int weight = Integer.parseInt(line.nextToken());
			if(max < weight)
				max = weight;
			
			list.get(from).add(new bridge(to, weight));
			list.get(to).add(new bridge(from, weight));
		}
		line = new StringTokenizer(br.readLine(), " ");
		int from = Integer.parseInt(line.nextToken());
		int to = Integer.parseInt(line.nextToken());
		
		int start = 0;
		int end = max + 1;
		int middle = (start + end) / 2;
		
		while(true) {
			if(valid(from, to, middle) && !valid(from, to, middle + 1))
				break;
			if(valid(from, to, middle)) {
				start = middle;
				middle = (start + end) / 2;
			}
			if(!valid(from, to, middle)) {
				end = middle;
				middle = (start + end) / 2;
			}
		}
		System.out.println(middle);
	}

}
