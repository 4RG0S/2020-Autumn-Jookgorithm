import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] graph;
    static char[][] bin;
    static int[] route;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        bin = new char[n+1][31];
        visit = new boolean[n+1];
        route = new int[n+1];
        int a, b, c;
        for(int i = 1; i <= n; i++) {
            bin[i] = br.readLine().toCharArray();
            for(int j = 1; j < i; j++){
                int cnt = 0;
                for(int l = 0; l < k; l++){
                    if(bin[i][l] != bin[j][l]) cnt++;
                }
                if(cnt == 1) graph[i][j] = graph[j][i] = 1;
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        bfs(s,e);
    }
    public static void bfs(int s, int e){
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.fill(route, -1);
        Arrays.fill(visit, false);
        Queue q = new LinkedList();
        q.add(s);
        visit[s] = true;
        route[s] = -1;
        while(!q.isEmpty()){
            int v = (int)q.remove();
            for(int j = 1; j <= n; j++){
                if(!visit[j]&&graph[v][j] == 1){
                    q.add(j);
                    visit[j] = true;
                    route[j] = v;
                }
            }
        }
        int i = e;
        while(route[i] != -1){
            list.add(i);
            i = route[i];
        }
        if(i != s) {
            System.out.println(-1);
        }
        else {
            list.add(i);
            for(int j = list.size()-1; j >= 0; j--)
                System.out.print(list.get(j)+" ");
        }
    }
}