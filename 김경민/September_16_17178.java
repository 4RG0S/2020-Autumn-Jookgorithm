package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class September_16_17178 {

	static class ticket implements Comparable<ticket> {
		char alpha;
		int num;

		public ticket(char alpha, int num) {
			this.alpha = alpha;
			this.num = num;
		}

		@Override
		public int compareTo(ticket o) {
			if (this.alpha - o.alpha > 0)
				return 1;
			else if (this.alpha - o.alpha < 0)
				return -1;
			else {
				return this.num - o.num;
			}
		}

	}
	
	static boolean ticket_equal(ticket o1, ticket o2)
	{
		if(o1.alpha == o2.alpha && o1.num == o2.num)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		Stack<ticket> stack = new Stack<>();
		int N = Integer.parseInt(line.nextToken());
		ticket arr[] = new ticket[N * 5];
		ticket sorted_arr[] = new ticket[N * 5];

		for (int i = 0; i < N; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				String split[] = line.nextToken().split("-");
				arr[i * 5 + j] = new ticket(split[0].charAt(0), Integer.parseInt(split[1]));
				sorted_arr[i * 5 + j] = new ticket(split[0].charAt(0), Integer.parseInt(split[1]));
			}
		}
		Arrays.sort(sorted_arr);
		int sorted_index = 0;
		for (int index = 0; index < N * 5; index++) {
			while(true)
			{
				if(stack.size() > 0 && ticket_equal(stack.peek(), sorted_arr[sorted_index]))
				{
					sorted_index++;
					stack.pop();
				}
				else
					break;
			}
			if(ticket_equal(arr[index], sorted_arr[sorted_index]))
			{
				sorted_index++;
				continue;
			}
			else
				stack.push(arr[index]);
		}
		while(true)
		{
			if(stack.size() > 0 && ticket_equal(stack.peek(), sorted_arr[sorted_index]))
			{
				sorted_index++;
				stack.pop();
			}
			else
				break;
		}
		//System.out.println(sorted_index);
		if(sorted_index == N * 5)
			System.out.println("GOOD");
		else
			System.out.println("BAD");
	}

}
