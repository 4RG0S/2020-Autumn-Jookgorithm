import java.util.*;

public class Main
{
	public static final Scanner scan = new Scanner(System.in);

    public static void main(String args[])
    {
    	int N = scan.nextInt();
    	Stack<Integer> stack = new Stack<Integer>();
    	StringBuffer sb = new StringBuffer();

        for(int i = 0; i<N; i++)
        {
        	String input = scan.next();

        	if(input.equals("push"))
        	{
        		stack.push(scan.nextInt());
        	}
        	else if(input.equals("pop"))
        	{
        		if(stack.size() == 0)
        		{
        			sb.append(-1+"\n");
        		}
        		else
        		{
        			sb.append(stack.pop()+"\n");
        		}
        	}
        	else if(input.equals("size"))
        	{
        		sb.append(stack.size()+"\n");
        	}
        	else if(input.equals("empty"))
        	{
        		if(stack.size() == 0)
        		{
        			sb.append(1+"\n");
        		}
        		else
        		{
        			sb.append(0+"\n");
        		}
        	}
        	else if(input.equals("top"))
        	{
        		if(stack.size() == 0)
        		{
        			sb.append(-1+"\n");
        		}
        		else
        		{
        			sb.append(stack.peek()+"\n");
        		}
        	}
        }

        System.out.println(sb.toString());
    }
}
