import java.util.*;

public class Main
{
   public static void main(String[] args)
   {
	   Scanner scan = new Scanner(System.in);
	   ArrayList<String> list = new ArrayList<String>();

	   String S = scan.nextLine();

	   for(int i=0; i<S.length(); i++)
	   {
		   list.add(S.substring(i, S.length()));
	   }

	  Collections.sort(list);

	  for(int i=0; i<S.length(); i++)
	  {
		   System.out.println(list.get(i));
	  }

	   scan.close();
   	}
}
