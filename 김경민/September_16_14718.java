package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class September_16_14718 {
	
	static soldier soldiers[];
	static int K;
	static int result = Integer.MAX_VALUE;
	
	static class soldier{
		int STR, DEX, INT;
		public soldier(int STR, int DEX, int INT)
		{
			this.STR = STR;
			this.DEX = DEX;
			this.INT = INT;
		}
	}
	
	static void check(int STR, int DEX, int INT)
	{
		int count = 0;
		for(int i=0;i<soldiers.length;i++)
		{
			if(soldiers[i].STR <= STR && soldiers[i].DEX <= DEX && soldiers[i].INT <= INT)
			{
				count++;
			}
		}
		if(count >= K)
		{
			if((STR + DEX + INT) < result)
				result = (STR + DEX + INT);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		K = Integer.parseInt(line.nextToken());
		soldiers = new soldier[N]; 
		
		for(int i=0;i<N;i++)
		{
			line = new StringTokenizer(br.readLine(), " ");
			soldiers[i] = new soldier(Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()));
		}
		for(int a=0;a<N;a++)
		{
			for(int b=0;b<N;b++)
			{
				for(int c=0;c<N;c++)
				{
					int STR = soldiers[a].STR;
					int DEX = soldiers[b].DEX;
					int INT = soldiers[c].INT;
					check(STR, DEX, INT);
				}
			}
		}
		System.out.println(result);
	}

}
