package September;

import java.util.Scanner;

public class September_15_3109 {
	
	static boolean map[][];
	static boolean find = false;
	
	static int dx[] = {1, 1, 1};
	static int dy[] = {-1, 0, 1};
	static int count = 0;
	
	static boolean is_valid(int x, int y)
	{
		if(0 <= x && x < map[0].length && 0 <= y && y < map.length)
		{
			return true;
		}
		return false;
	}
	
	static void dfs(int x, int y) {
		if(x == map[0].length - 1)
		{
			find = true;
			count++;
		}
		for(int i=0;i<3;i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(is_valid(tx, ty) && !map[ty][tx] && !find)
			{
				map[ty][tx] = true;
				dfs(tx, ty);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		scan.nextLine();
		map = new boolean[R][C];
		
		for(int i=0;i<R;i++)
		{
			String line = scan.nextLine();
			for(int j=0;j<C;j++)
			{
				if(line.charAt(j) == 'x')
					map[i][j] = true;
			}
		}
		for(int i=0;i<R;i++)
		{
			find = false;
			dfs(0, i);
		}
		System.out.println(count);
	}

}
