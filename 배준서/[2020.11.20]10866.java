import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
	   Deque<Integer> deque = new LinkedList<>();
	   StringBuilder sb = new StringBuilder();
	   Scanner sc = new Scanner(System.in);

	   int cnt = sc.nextInt();

	   for(int i=0; i<cnt; i++)
	   {
		   String a = sc.next();
		   if(a.equals("push_back"))
		   {
			   int b = sc.nextInt();
			   deque.addLast(b);
		   }
		   else if(a.equals("push_front"))
		   {
			   int b = sc.nextInt();
			   deque.addFirst(b);
		   }
		   else if(a.equals("pop_front"))
		   {
			   sb.append(Integer.toString(deque.isEmpty()?-1:deque.pop())+"\n");
		   }
		   else if(a.equals("pop_back"))
		   {
			   sb.append(Integer.toString(deque.isEmpty()?-1:deque.removeLast())+"\n");
		   }
		   else if(a.equals("size"))
		   {
			   sb.append(Integer.toString(deque.size())+"\n");
		   }
		   else if(a.equals("empty"))
		   {
			   sb.append(Integer.toString(deque.isEmpty()?1:0)+"\n");
		   }
		   else if(a.equals("front"))
		   {
			   sb.append(Integer.toString(deque.isEmpty()?-1:deque.peek())+"\n");
		   }
		   else if(a.equals("back"))
		   {
			   sb.append(Integer.toString(deque.isEmpty()?-1:deque.peekLast())+"\n");
		   }
	   }

	   System.out.println(sb.toString());
   	}
}
