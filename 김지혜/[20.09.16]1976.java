import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] city = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int a = scan.nextInt();
                city[i][j] = a;
            }
        }
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i] = i;

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(city[i][j] == 1){
                    int iParent = find(parent, i);
                    int jParent = find(parent, j);
                    if(iParent<jParent) parent[jParent] = iParent;
                    else parent[iParent] = jParent;
                }
            }
        }
        int[] trip = new int[m];
        for(int i=0;i<m;i++){
            trip[i] = scan.nextInt();
        }

        if(!isPossible(parent, trip, m)) System.out.println("NO");
        else System.out.println("YES");
    }
    public static boolean isPossible(int[] parent, int[] trip, int m){
        int test = parent[trip[0]];
        for(int i=1;i<m;i++){
            if(find(parent, test)!=find(parent, trip[i]))
                return false;

        }
        return true;
    }
    public static int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }
}