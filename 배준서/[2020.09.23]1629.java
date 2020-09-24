import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		long value =1;
		long multiy = A%C;
		
		while(B>0)
		{
			if(B%2 == 1)
			{
				value *= multiy;
				value %= C;
			}
			multiy = ((multiy%C) * (multiy%C)) % C;
			B /= 2;
		}
		
		System.out.println(value);
	}
}

//시간 복잡도를 활용한 문제이다.
//int크기인 2147483647만큼을 제곱하면 단순 for문은 2147483647번 계산하지만, 이를 활용하면 2^31 = 2147483647이므로 31번만에 해결 가능하다.
