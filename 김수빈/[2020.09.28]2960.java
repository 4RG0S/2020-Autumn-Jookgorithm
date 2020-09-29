import java.util.*;

public class Main {

   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in);
      int A = scan.nextInt();
      int B = scan.nextInt();
      List<Integer> list = new ArrayList<Integer>();
      for(int i = 2; i<=A; i++) {
    	  list.add(i);
      }
      int a = 0;
      for(int k = 2;k<=A;k++) {
    	  for(int j = 0; j<list.size();j++) {
    		  if(list.get(j)%k==0) {
    			a++;
    			if(a==B) {
    				System.out.println(list.get(j));
    			}
    			list.remove(j);
    		  }
    	  }
      }
      
      
      
      scan.close();
   }

}