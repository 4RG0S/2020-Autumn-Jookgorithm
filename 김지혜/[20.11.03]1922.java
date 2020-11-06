import java.io.IOException;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int cost;
        public Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost>o.cost) return 1;
            else if(this.cost<o.cost) return -1;
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        List<Edge>[] list = new LinkedList[n+1];
        for(int i=0;i<n+1;i++){
            list[i] = new LinkedList<>();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            list[a].add(new Edge(a, b, c));
            list[b].add(new Edge(b, a, c));
        }

        int[] visited = new int[n+1];
        for(Edge e : list[1]){
            pq.add(e);
        }
        visited[1] = 1;
        int sum = 0;
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int u = curEdge.u;
            int v = curEdge.v;
            int cost = curEdge.cost;

            if(visited[v]==1) continue;
            visited[v] = 1;
            sum = sum+cost;

            List<Edge> curList = list[v];
            for(Edge e : curList) {
                if(visited[e.v]==0)
                    pq.add(e);
            }
        }
        System.out.println(sum);
    }
}