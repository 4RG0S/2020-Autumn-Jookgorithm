import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++)
            parent[i] = i;

        for(int i=0;i<m;i++){
            int p = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();

            if(p == 0){
                union(parent, a, b);
            }
            else{
                if(find(parent, a)==find(parent, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
    public static int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return parent[i]=find(parent, parent[i]);
    }
    public static void union(int[] parent, int a, int b){
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if(aParent!=bParent){
            parent[bParent] = aParent;
        }

    }

}