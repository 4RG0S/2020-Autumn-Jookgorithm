import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Graph implements Comparable<Graph> {
        int start;
        int end;
        int weight;

        public Graph(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph o) {
            if(this.weight<o.weight)
                return -1;
            else if(this.weight>o.weight)
                return 1;
            else{
                if(this.start<o.start)
                    return -1;
                else if(this.start>o.start)
                    return 1;
                else return 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        int[] parent = new int[a+1];
        for(int i=1;i<=a;i++)
            parent[i] = i;

        PriorityQueue<Graph> pq = new PriorityQueue<>();
        for(int i=0;i<b;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();

            pq.add(new Graph(x, y, w));
        }
        parent[1] = 1;
        int sum = 0;
        while(!pq.isEmpty()){
            Graph graph = pq.poll();
            int start = graph.start;
            int end = graph.end;
            int weight = graph.weight;

            if(!cycle(parent, start, end)){
                union(parent, start, end);
                sum += weight;
            }
        }
        System.out.println(sum);
    }
    public static boolean cycle(int[] parent, int a, int b){
        return find(parent, a) == find(parent, b);
    }
    public static int find(int[] parent, int v){
        if(parent[v] == v) return v;
        return find(parent, parent[v]);
    }
    public static void union(int[] parent, int a, int b){
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if(aParent<bParent)
            parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }

}