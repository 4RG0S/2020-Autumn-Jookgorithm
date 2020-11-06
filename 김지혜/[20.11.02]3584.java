import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i=0;i<T;i++){
            int n = scan.nextInt();
            parent = new int[n+1];

            for(int j=0;j<n-1;j++){
                int p = scan.nextInt();
                int s = scan.nextInt();

                parent[s] = p;
            }
            int a = scan.nextInt();
            int b = scan.nextInt();

            int aParent = a;
            int bParent = b;
            while(aParent!=0){
                while(aParent!=bParent && bParent!=0)
                    bParent = parent[bParent];

                if(aParent==bParent){
                    System.out.println(aParent);
                    break;
                }
                else{
                    bParent = b;
                    aParent = parent[aParent];
                }
            }
        }
    }
}