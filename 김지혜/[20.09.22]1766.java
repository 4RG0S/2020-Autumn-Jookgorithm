import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n+1];
        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            arr.get(a).add(b);
            indegree[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0) pq.add(i);
        }

        for(int i=0;i<n;i++){
            int cur = pq.poll();
            System.out.print(cur+" ");
            ArrayList<Integer> curArr = arr.get(cur);

            for(int j=0;j<curArr.size();j++){
                int next = curArr.get(j);
                indegree[next]--;

                if(indegree[next]==0) pq.add(next);
            }
        }
    }
}