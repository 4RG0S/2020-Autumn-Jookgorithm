import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Distance implements Comparable<Distance>{
        int a;
        int b;
        double dist;
        public Distance(int a, int b, double dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Distance o) {
            if(this.dist > o.dist) return 1;
            else if(this.dist < o.dist) return -1;
            return 0;
        }
    }
    public static class Pair{
        double x;
        double y;
        public Pair(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static double sum=0;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        Pair[] input = new Pair[n];

        int[] parent = new int[n+1];
        for(int i=0;i<n;i++){
            input[i] = new Pair(scan.nextDouble(), scan.nextDouble());
        }
        for(int i=0;i<n;i++){
            parent[i] = i;
            for(int j=i+1;j<n;j++){
                Pair aPair = input[i];
                Pair bPair = input[j];

                double distance = Math.sqrt(Math.pow((aPair.x-bPair.x), 2)+Math.pow((aPair.y-bPair.y), 2));
                pq.add(new Distance(i, j, distance));
            }
        }
        while (!pq.isEmpty()) {
            Distance aDist = pq.poll();
            union(parent, aDist);
        }
        System.out.println(String.format("%.2f",sum));
    }
    public static void union(int[] parent, Distance aDist){
        int i = aDist.a;
        int j = aDist.b;
        int iParent = find(parent, i);
        int jParent = find(parent, j);

        if(iParent != jParent){
            if(iParent<jParent) parent[jParent] = iParent;
            else parent[iParent] = jParent;
            sum = sum + aDist.dist;
        }

    }
    public static int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }
}