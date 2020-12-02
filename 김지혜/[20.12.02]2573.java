import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] input;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        input = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                input[i][j] = scan.nextInt();
            }
        }
        int day = 0;
        boolean allSolid = false;
        while(iceberg()<2){
            allSolid = true;
            int[][] tmpArr = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(input[i][j]==0) continue;
                    allSolid = false;
                    int solid = 0;

                    if(i-1>=0 && input[i-1][j]==0) solid++;
                    if(i+1<n && input[i+1][j]==0) solid++;
                    if(j-1>=0 && input[i][j-1]==0) solid++;
                    if(j+1<m && input[i][j+1]==0) solid++;

                    tmpArr[i][j] = Math.max(input[i][j] - solid, 0);
                }
            }
            if(allSolid) break;
            input = tmpArr;
            day++;
        }
        if(allSolid) System.out.println(0);
        else System.out.println(day);


    }
    public static int iceberg(){
        boolean[][] visited = new boolean[n][m];

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && input[i][j]>0) {
                    BFS(visited, i, j);
                    answer ++;
                }
            }
        }
        return answer;
    }
    public static void BFS(boolean[][] visited, int i, int j){
        if(i>=n || j>=m || i<0 || j<0)
            return;
        if(visited[i][j] || input[i][j]==0) return;
        visited[i][j] = true;

        BFS(visited, i+1, j);
        BFS(visited, i-1, j);
        BFS(visited, i, j+1);
        BFS(visited, i, j-1);
    }

}
