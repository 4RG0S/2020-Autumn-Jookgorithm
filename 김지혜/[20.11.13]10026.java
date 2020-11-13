import java.io.IOException;
import java.util.Scanner;

public class Main {

    static char[][] input;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        input = new char[n][n];

        for(int i=0;i<n;i++){
            String inputStr = scan.next();
            for(int j=0;j<n;j++){
                input[i][j] = inputStr.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][n];
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i, j, visited, false, input[i][j]);
                    sum++;
                }
            }
        }
        System.out.print(sum+" ");
        visited = new boolean[n][n];
        sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i, j, visited, true, input[i][j]);
                    sum++;
                }
            }
        }
        System.out.print(sum+" ");
    }
    public static void DFS(int i, int j, boolean[][] visited, boolean isGreen, char color){
        if(i<0 || i>=n || j<0 || j>=n || visited[i][j]) return;

        if(input[i][j]==color||(isGreen&&(color=='R'||color=='G')&&(input[i][j]=='R'||input[i][j]=='G'))){
            visited[i][j] = true;
            DFS(i-1, j, visited, isGreen, color);
            DFS(i, j-1, visited, isGreen, color);
            DFS(i+1, j, visited, isGreen, color);
            DFS(i, j+1, visited, isGreen, color);
        }
    }
}