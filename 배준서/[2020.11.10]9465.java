import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
        Scanner scan = new Scanner(System.in);

        //테스트 케이스 입력.
        int T = scan.nextInt();

        for(int t=0; t<T; t++)
        {
        	//정수의 갯수 입력.
        	int n = scan.nextInt();

        	int arr[][] = new int[2][n+1];
        	int dp[][] = new int[n+1][3];	//위아래로 구분 시 XX, OX, XO밖에 없는 총 3가지 조건이므로, dp의 열의 갯수도 3.

        	for(int i=0; i<2; i++)
        	{
        		for(int j=1; j<=n; j++)
        		{
        			//n개 만큼의 정수 두줄 입력.
        			arr[i][j] = scan.nextInt();
        		}
        	}
        	//스티커를 땐 자리가 O, 못땐 자리는 X이면,
        	dp[1][0] = 0;			// X X 의 경우
        	dp[1][1] = arr[0][1];	// O X 의 경우
        	dp[1][2] = arr[1][1];	// X O 의 경우

        	for(int i=2; i<=n; i++)
        	{
        		dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        		dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[0][i];
        		dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[1][i];
        	}
        	System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
	}
}
