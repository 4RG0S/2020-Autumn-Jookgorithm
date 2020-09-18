package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class September_16_14725 {
	
	static Node root;
	
	static class Data implements Comparable<Data>
	{
		String words[];
		public Data(String words[])
		{
			this.words = new String[words.length];
			for(int i=0;i<words.length;i++)
			{
				this.words[i] = words[i];
			}
		}
		@Override
		public int compareTo(Data o) {
			for(int i=0;i<Integer.min(this.words.length, o.words.length);i++)
			{
				if(this.words[i].compareTo(o.words[i]) > 0)
					return 1;
				else if(this.words[i].compareTo(o.words[i]) < 0)
					return -1;
			}
			return this.words.length - o.words.length;
		}
		public String toString() {
			String result = "";
			for(int i=0;i<words.length;i++)
			{
				result += words[i] + " ";
			}
			return result;
		}
	}
	
	static class Node{
		List<Node> children = new ArrayList<>();
		String data;
		public Node(String data)
		{
			this.data = data;
		}
		public void add_data(String data)
		{
			children.add(new Node(data));
		}
		public String getData() {
			return data;
		}
		
	}
	
	@SuppressWarnings("static-access")
	static void print_data(Data input)
	{
		Node temp = root;
		//System.out.println(temp.children.size());
		boolean conti = false;
		for(int i=0;i<input.words.length;i++)
		{
			conti = false;
			for(int j=0;j<temp.children.size();j++)
			{
				String data = temp.children.get(j).getData();
				if(input.words[i].equals(data))
				{
					temp = temp.children.get(j);
					//System.out.println("continue");
					conti = true;
					break;
				}
			}
			if(conti)
				continue;
			Node add = new Node(input.words[i]);
			temp.children.add(add);
			temp = add;
			for(int j=0;j<i;j++)
			{
				System.out.print("--");
			}
			System.out.println(input.words[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		root = new Node("");
		int N = Integer.parseInt(line.nextToken());
		Data data[] = new Data[N];
		for(int i=0;i<N;i++)
		{
			line = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(line.nextToken());
			String arr[] = new String[size];
			for(int j=0;j<size;j++)
			{
				arr[j] = line.nextToken();
			}
			data[i] = new Data(arr);
		}
		Arrays.sort(data);
		for(int i=0;i<data.length;i++)
		{
			print_data(data[i]);
		}
	}

}
