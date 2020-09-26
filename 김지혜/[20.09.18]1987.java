import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static char[][] road;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        Map<Character, Integer> visited = new HashMap<>();
        road = new char[n][m];
        for(int i=0;i<n;i++){
            String str = scan.next();
            for(int j=0;j<m;j++){
                road[i][j] = str.charAt(j);
            }
        }
        System.out.println(DFS(visited, 0, 0, n, m));
    }
    public static int DFS(Map<Character, Integer> visited, int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m) return 0;
        if(visited.containsKey(road[i][j])) return 0;

        visited.put(road[i][j], 1);
        int up = DFS(visited, i-1, j, n, m);
        int down = DFS(visited, i+1, j, n, m);
        int left = DFS(visited, i, j-1, n, m);
        int right = DFS(visited, i, j+1, n, m);

        int sum = Math.max(up, Math.max(down, Math.max(left, right)));
        visited.remove(road[i][j]);
        return 1+sum;
    }

}