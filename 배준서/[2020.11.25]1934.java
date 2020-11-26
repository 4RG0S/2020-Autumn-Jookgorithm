import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=0;i<count;i++) 
        {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int gcdValue = gcd(a, b);
			int lcmValue = a*b/gcdValue;
			System.out.println(lcmValue);
		}
	}

	public static int gcd(int a, int b) 
    {
		if (b > a)
        {
			int temp = a;
			a = b;
			b = temp;
		}
		if (b == 0) 
        {
			return a;
		} 
        else 
        {
			return gcd(b, a % b);
		}
	}
}
