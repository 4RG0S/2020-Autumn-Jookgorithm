import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
	    Scanner scan = new Scanner(System.in);
	    Stack<Integer> stack = new Stack<Integer>();

	    int K = scan.nextInt();
	    int ans = 0;

	    for(int i=0; i<K; i++)
	    {
	    	int input = scan.nextInt();

	    	if(input == 0)
	    	{
	    		stack.pop();
	    	}
	    	else
	    	{
	    		stack.push(input);
	    	}
	    }

	    for(int i=0; i<stack.size(); i++)
	    {
	    	ans += stack.get(i);
	    }
	    System.out.println(ans);
	}
}
