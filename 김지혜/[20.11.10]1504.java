import java.io.IOException;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node){
            if(this.cost>node.cost) return 1;
            else if(this.cost<node.cost) return -1;
            return 0;
        }

    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        HashMap<Integer, HashMap<Integer, Integer>> inputMap = new HashMap<>();
        for(int i=0;i<=n;i++){
            inputMap.put(i, new HashMap<>());
        }
        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            inputMap.get(a).put(b, c);
            inputMap.get(b).put(a, c);
        }
        int ess1 = scan.nextInt();
        int ess2 = scan.nextInt();

        int startToEss1 = dijkstra(1, ess1, n, inputMap);
        int ess1ToEss2 = dijkstra(ess1, ess2, n, inputMap);
        int ess2ToN = dijkstra(ess2, n, n, inputMap);

        int startToEss2 = dijkstra(1, ess2, n, inputMap);
        int ess2ToEss1 = dijkstra(ess2, ess1, n, inputMap);
        int ess1ToN = dijkstra(ess1, n, n, inputMap);

        int answer1 = startToEss1 + ess1ToEss2 + ess2ToN;
        int answer2 = startToEss2 + ess2ToEss1 + ess1ToN;

        if((answer1<0 && answer2<0) || (answer1>= 800000 && answer2>=800000)){
            System.out.println(-1);
        }
        else{
            if(answer1<0 || answer1>=800000) System.out.println(answer2);
            else if(answer2<0 || answer2>=800000) System.out.println(answer1);
            else System.out.println(Math.min(answer1, answer2));
        }


    }

    private static int dijkstra(int start, int end, int n, HashMap<Integer, HashMap<Integer, Integer>> inputMap) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int[] visited = new int[n+1];

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node curNode = q.poll();
            int cur = curNode.v;
            int cost = curNode.cost;
            if(visited[cur]==1) continue;
            visited[cur] = 1;
            HashMap<Integer, Integer> curMap = inputMap.get(cur);
            Set<Integer> keySet = curMap.keySet();
            Iterator<Integer> iter = keySet.iterator();
            while(iter.hasNext()){
                int next = iter.next();
                int nextCost = curMap.get(next);

                if(visited[next]==0 && dist[cur]+nextCost<dist[next]) {
                    dist[next] = dist[cur]+nextCost;
                    q.add(new Node(next, dist[next]));
                }
            }

        }
        return dist[end];
    }


}