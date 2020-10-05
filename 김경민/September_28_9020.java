package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class September_28_9020 {
	
	static List<Integer> prime;
	
	static boolean isPrime(int n)
	{
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		prime = new ArrayList<>();
		for(int i=2;i<=20000;i++)
		{
			if(isPrime(i))
				prime.add(i);
		}
		int T = Integer.parseInt(line.nextToken());
		for(int i=0;i<T;i++)
		{
			int num = Integer.parseInt(br.readLine());
			int a = 0, b = 0;
			for(int j=0;;j++)
			{
				int peek = prime.get(j);
				if(peek >= num)
					break;
				for(int k=j;;k++)
				{
					int peek2 = prime.get(k);
					if(peek2 >= num)
						break;
					if(peek + peek2 == num)
					{
						a = peek;
						b = peek2;
					}
				}
			}
			System.out.println(a + " " + b);
		}
	}

}
