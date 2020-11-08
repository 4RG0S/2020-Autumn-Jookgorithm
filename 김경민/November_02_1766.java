package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_02_1766 {
	
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		int count[] = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			list.get(from).add(to);
			count[to]++;
		}
		for(int i=1;i<=N;i++) {
			if(count[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int i=0;i<list.get(temp).size();i++) {
				count[list.get(temp).get(i)]--;
				if(count[list.get(temp).get(i)] == 0) {
					q.add(list.get(temp).get(i));
				}
			}
		}
	}

}
