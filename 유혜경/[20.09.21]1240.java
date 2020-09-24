import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] min;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visit = new boolean[n+1];
        min = new int[n+1];
        int v1 , v2, len;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = len;
        }
        int s, e;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            System.out.println(bfs(s,e));
        }
    }
    public static int bfs(int s, int e){
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(visit, false);
        Queue q = new LinkedList();
        q.add(s);
        visit[s] = true;
        min[s] = 0;
        while(!q.isEmpty()){
            int v = (int)q.remove();
            for(int j = 1; j <= n; j++){
                if(!visit[j]&&graph[v][j] != 0){
                    q.add(j);
                    visit[j] = true;
                    min[j] = Math.min(min[j], graph[v][j]+min[v]);
                }
            }
        }
        return min[e];
    }
}