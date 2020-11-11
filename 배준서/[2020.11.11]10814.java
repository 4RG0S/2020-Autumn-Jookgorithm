import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		String[][] arr = new String[N][2];


		for(int i = 0; i < N; i++)
		{
			arr[i][0] = scan.next();
			arr[i][1] = scan.next();
		}


		Arrays.sort(arr, new Comparator<String[]>()
		{

			@Override
			public int compare(String[] s1, String[] s2)
			{
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}

		});

		for(int i = 0; i < N; i++)
		{
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}
