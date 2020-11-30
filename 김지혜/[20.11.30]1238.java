import java.io.IOException;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int src;
        int dist;

        public Node(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dist>o.dist) return 1;
            else if(this.dist<o.dist) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int start = scan.nextInt();

        int[][] house = new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(house[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<M;i++){
            int src = scan.nextInt();
            int dest = scan.nextInt();
            int dist = scan.nextInt();
            house[src][dest] = dist;
        }
        int[] dijkstraFromStart = dijkstra(N, house, start);
        int max = 0;
        for(int i=1;i<=N;i++){
            int[] dijkarr = dijkstra(N, house, i);
            if(dijkarr[start]<Integer.MAX_VALUE && dijkstraFromStart[i]<Integer.MAX_VALUE)
                max = Math.max(dijkarr[start]+dijkstraFromStart[i], max);
        }
        System.out.println(max);
    }
    public static int[] dijkstra(int N, int[][] house, int start){
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N+1];

        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            int person = pq.poll().src;
            if(visited[person]) continue;
            visited[person] = true;

            for(int i=1;i<=N;i++){
                if(house[person][i]<Integer.MAX_VALUE && distance[i] > distance[person]+house[person][i]){
                    distance[i] = distance[person]+house[person][i];
                    pq.add(new Node(i, distance[i]));
                }
            }
        }
        return distance;
    }

}