import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[50];
		int[] rst = new int[50];

		for(int i=0; i<N; i++) 
		{
			arr[i] = sc.nextInt();
			
			for(int j=0; j<i; j++) 
			{
				if(arr[j] > arr[i])
				{
					rst[j]++;
				}
				else
				{
					rst[i]++;
				}
			}

		}

		for(int i=0; i<N; i++) 
		{
			System.out.print(rst[i]+" ");
		}
	}
}
