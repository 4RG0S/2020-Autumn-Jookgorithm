import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static int[][] graph;
    static int[] min;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visit = new boolean[n+1];
        int v1 , v2, len;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = 1;
        }
        System.out.println(dfs(v));
        System.out.println(bfs(v));
    }
    public static String dfs(int s){
        StringBuilder sb = new StringBuilder();
        Arrays.fill(visit, false);
        Stack st = new Stack();
        st.push(s);
        while(!st.isEmpty()){
            int v = (int)st.pop();
            if(visit[v] == false) {
                visit[v] = true;
                sb.append(v + " ");
                for (int j = n; j >= 1; j--) {
                    if (!visit[j] && graph[v][j] != 0) st.push(j);
                }
            }
        }
        return sb.toString();
    }
    public static String bfs(int s){
        StringBuilder sb = new StringBuilder();
        Arrays.fill(visit, false);
        Queue q = new LinkedList();
        q.add(s);
        visit[s] = true;
        while(!q.isEmpty()){
            int v = (int)q.remove();
            sb.append(v+" ");
            for(int j = 1; j <= n; j++){
                if(!visit[j]&&graph[v][j] != 0){
                    q.add(j);
                    visit[j] = true;
                }
            }
        }
        return sb.toString();
    }
}