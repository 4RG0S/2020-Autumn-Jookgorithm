package September;

import java.util.Scanner;

public class September_18_16509 {
	
	static int dx1[] = {1, 0, -1, 0};
	static int dy1[] = {0, -1, 0, 1};
	static int dx2[] = {1, 1, -1, -1};
	static int dy2[] = {1, -1, -1, 1};
	static int king_x;
	static int king_y;
	
	static int dist[][] = new int[10][9];
	
	static void dijkstra(int x, int y, int count)
	{
		for(int i=0;i<4;i++)
		{
			int tx = x + dx1[i];
			int ty = y + dy1[i];
			if(is_range(tx, ty) && !(king_x == tx && king_y == ty))
			{
				int ux = tx + dx2[i];
				int uy = ty + dy2[i];
				if(is_range(ux, uy) && !(king_x == ux && king_y == uy))
				{
					ux += dx2[i];
					uy += dy2[i];
					if(is_range(ux, uy))
					{
						if(dist[uy][ux] == Integer.MAX_VALUE || dist[uy][ux] > count + 1)
						{
							dist[uy][ux] = count + 1;
							dijkstra(ux, uy, count + 1);
						}
					}
				}
				ux = tx + dx2[(i + 1) % 4];
				uy = ty + dy2[(i + 1) % 4];
				if(is_range(ux, uy) && !(king_x == ux && king_y == uy))
				{
					ux += dx2[(i + 1) % 4];
					uy += dy2[(i + 1) % 4];
					if(is_range(ux, uy))
					{
						if(dist[uy][ux] == Integer.MAX_VALUE || dist[uy][ux] > count + 1)
						{
							dist[uy][ux] = count + 1;
							dijkstra(ux, uy, count + 1);
						}
					}
				}
			}
		}
	}
	
	static boolean is_range(int x, int y)
	{
		if(0 <= x && x < 9 && 0 <= y && y < 10)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int y = scan.nextInt();
		int x = scan.nextInt();
		king_y = scan.nextInt();
		king_x = scan.nextInt();
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<9;j++)
			{
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[y][x] = 0;
		dijkstra(x, y, 0);
		/*
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(dist[i][j] == Integer.MAX_VALUE)
					System.out.print(-1 + " ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}*/
		if(dist[king_y][king_x] != Integer.MAX_VALUE)
			System.out.println(dist[king_y][king_x]);
		else
			System.out.println(-1);
	}

}
