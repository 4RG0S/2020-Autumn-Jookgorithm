import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            int loop = scan.nextInt();

            int[] visited = new int[m];
            for (int j = 0; j < loop; j++) {
                visited[scan.nextInt() - 1] = 1;
                visited[scan.nextInt() - 1] = 1;
            }
            if(searchAll(visited, m))
                System.out.println(m-1);
            else System.out.println(0);
        }
    }
    public static boolean searchAll(int[] visited, int n){
        for(int i=0;i<n;i++){
            if(visited[i]==0) return false;
        }
        return true;
    }
}