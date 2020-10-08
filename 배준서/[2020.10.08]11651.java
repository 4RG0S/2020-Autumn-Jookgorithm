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
		
		Arrays.sort(points, new Comparator<Point>()
		{
			@Override
			public int compare(Point a, Point b) 
			{
				if (a.y == b.y)
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
