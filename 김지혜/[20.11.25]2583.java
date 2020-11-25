import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static boolean[][] paper;
    static boolean[][] visited;

    static int m;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        k = scan.nextInt();

        paper = new boolean[m][n];
        visited = new boolean[m][n];

        for(int i=0;i<k;i++){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int j=x1;j<x2;j++){
                for(int h=y1;h<y2;h++){
                    paper[h][j] = true;
                    visited[h][j] = true;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && !paper[i][j])
                    arr.add(DFS(i, j));
            }
        }
        System.out.println(arr.size());
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
    public static int DFS(int i, int j){
        if(i>=m || i<0 || j>=n || j<0) return 0;
        if(paper[i][j] || visited[i][j]) return 0;
        visited[i][j] = true;

        return 1+DFS(i-1, j)+DFS(i+1, j)+DFS(i, j-1)+DFS(i, j+1);
    }
}