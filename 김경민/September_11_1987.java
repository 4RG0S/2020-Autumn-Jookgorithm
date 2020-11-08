package September;

import java.util.HashSet;
import java.util.Scanner;

public class September_11_1987 {
	
	static char arr[][];
	static int max = Integer.MIN_VALUE;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		HashSet<Character> set = new HashSet<>();
		int R = scan.nextInt();
		int C = scan.nextInt();
		scan.nextLine();
		arr = new char[R][C];
		for(int i=0;i<R;i++)
		{
			String line = scan.nextLine();
			for(int j=0;j<line.length();j++)
			{
				arr[i][j] = line.charAt(j);
			}
		}
		dfs(0, 0, set);
		System.out.println(max);
	}

	static void dfs(int x, int y, HashSet<Character> set)
	{
		char mem = arr[y][x];
		set.add(mem);
		if(max < set.size())
			max = set.size();
		for(int i=0;i<4;i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(0 <= tx && tx < arr[0].length && 0 <= ty && ty < arr.length)
			{
				if(set.contains(arr[ty][tx]))
					continue;
				dfs(tx, ty, set);
			}
		}
		set.remove(mem);
	}
}
