import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int T;
        String[] num;
        
        T = Integer.parseInt(scan.nextLine());
        
        while(T>0)
        {
        	num = scan.nextLine().split(",");
        	
        	System.out.println(Integer.parseInt(num[0]) + Integer.parseInt(num[1]));
        	T--;
        }

        
        scan.close();
    }
}
