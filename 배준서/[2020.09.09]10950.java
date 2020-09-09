import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int check = 0;
        int a = 0;
        int b = 0;
        
        check = scan.nextInt();
        
        int[] arr = new int[check];

        for(int i=0; i<check; i++)
        {
            a = scan.nextInt();
            b = scan.nextInt();
            
            arr[i] = a + b;
        }
        
        for(int i=0; i<arr.length; i++)
        {
        	System.out.println(arr[i]);
        }
        
        scan.close();
    }
}
