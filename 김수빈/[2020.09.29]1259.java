import java.util.*;

public class Main {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int num = 1;
      i:while(scan.hasNextInt()) {
    	  num = scan.nextInt();
    	  if(num == 0) {
    		  scan.close();
    		  break i;
    	  }
    	  String[] str = Integer.toString(num).split("");
    	  if(str.length==1) {
    		  System.out.println("yes");
    		  continue;
    	  }
    	  int a = 0;
    	  int b = 0;
    	  ii:while(a!=(str.length/2)) {
    		  if(!str[a].equals(str[str.length-a-1])) {
    			  System.out.println("no");
    			  break ii;  
    		  }
    		  a++;
    		  b++;
    		  if(b==str.length/2) {
    			  System.out.println("yes");
    			  break ii;
    		  }
    	  }
      }
   }

}