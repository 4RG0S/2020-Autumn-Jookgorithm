import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		
		for(int i=0; i<N; i++)
		{
			String array[] = br.readLine().split(" ");
			points[i] = new Point(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
		}
		
		//x좌표가 정렬됨에 따라 y좌표값도 연결되어 있으므로 각각 맞춘다.
		Arrays.sort(points, new Comparator<Point>() 
		{
			@Override
			public int compare(Point a, Point b) 
			{
				if (a.x != b.x)
					return a.x - b.x;
				else
					return a.y - b.y;
			}
		 });
		
		for(Point value : points)
		{
			sb.append(value.x).append(" ").append(value.y).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
