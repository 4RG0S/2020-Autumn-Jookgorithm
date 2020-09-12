import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int L = 0;
        String text = "";
        
        L = scan.nextInt();
        scan.nextLine();
        text = scan.nextLine();
        
        int[] pi = getPi(text);
        System.out.println(L - pi[L - 1]);
        
        scan.close();
    }
    
    private static int[] getPi(String pattern)
    {    	    	
    	int m = pattern.length();
		int j = 0;
		int[] pi = new int[m];

		for (int i = 1; i < m; i++) {

			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
    }
}
