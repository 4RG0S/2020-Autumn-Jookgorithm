import java.util.*;

public class Main
{
	static int N,M = 0;       
    static int arr[],check[];
	
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        N = scan.nextInt();
        M = scan.nextInt();
      
        arr = new int[9];
        check = new int[9];
        depthFirstSearch(0);
       
        scan.close();
    }
    
    static void depthFirstSearch(int count)
    {
    	if(count == M)
    	{
    		for(int i=0; i<M; i++)
    		{
    			System.out.print(arr[i]+" ");
    		}
    		System.out.println("");
    		return;
    	}
    	for(int i=1; i<=N; i++)
    	{
    		if(check[i]==1)
    			continue;
    		check[i]=1;
    		arr[count]=i;
    		depthFirstSearch(count+1);
    		check[i]=0;
    	}
    }
}
