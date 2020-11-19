import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
	   int b=0;
	   Queue<Integer> que = new LinkedList<>();
	   Scanner scan = new Scanner(System.in);
	   StringBuffer sb = new StringBuffer();

	   int cnt = scan.nextInt();

	   for(int i=0; i<cnt; i++)
	   {
		   String a = scan.next();
		   if(a.equals("push"))
		   {
			   b = scan.nextInt();
			   que.add(b);
		   }
		   else if(a.equals("front"))
		   {
			   sb.append(Integer.toString(que.isEmpty()?-1:que.peek()) + "\n");
		   }
		   else if(a.equals("back"))
		   {
			   sb.append(Integer.toString((que.isEmpty()?-1:b)) + "\n");
		   }
		   else if(a.equals("size"))
		   {
			   sb.append(Integer.toString(que.size()) + "\n");
		   }
		   else if(a.equals("pop"))
		   {
			   sb.append(Integer.toString(que.isEmpty()?-1:que.poll()) + "\n");
		   }
		   else if(a.equals("empty"))
		   {
			   sb.append(Integer.toString(que.isEmpty()?1:0) + "\n");
		   }
	   }

	   System.out.println(sb.toString());
	}
}
