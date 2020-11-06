import java.io.IOException;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost>o.cost) return 1;
            else if(this.cost<o.cost) return -1;
            else return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        ArrayList<Node>[] nodes = new ArrayList[n+1];

        for(int i=0;i<n+1;i++)
            nodes[i] = new ArrayList<>();

        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<nodes[1].size();i++){
            pq.add(nodes[1].get(i));
        }
        int[] visited = new int[n+1];
        visited[1] = 1;

        int sum = 0;
        int max = 0;
        int count = 0;
        while(!pq.isEmpty() && count<n-1){
            Node curNode = pq.poll();

            if(visited[curNode.v] == 1) continue;
            visited[curNode.v] = 1;
            sum = sum + curNode.cost;
            max = Math.max(curNode.cost, max);
            count++;

            for(int i=0;i<nodes[curNode.v].size();i++){
                pq.add(nodes[curNode.v].get(i));
            }
        }
        System.out.println(sum-max);
    }
}