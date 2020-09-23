import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        for(int i=0;i<testCase;i++){
            int n = scan.nextInt();
            int m = scan.nextInt();

            int[] indegree = new int[n+1];
            int[] time = new int[n+1];

            for(int j=1;j<=n;j++){
                time[j] = scan.nextInt();
            }
            List<List<Integer>> list = new ArrayList<>();
            for(int j=0;j<=n;j++){
                list.add(new ArrayList<Integer>());
            }
            for(int j=1;j<=m;j++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                list.get(a).add(b);
                indegree[b]++;
            }
            int last = scan.nextInt();

            int[] visited = new int[n+1];
            Queue<Integer> q = new LinkedList<>();

            int[] construction = new int[n+1];
            Arrays.fill(construction, 0);
            for(int j=1;j<=n;j++){
                if(indegree[j]==0) {
                    q.add(j);
                    construction[j] = time[j];
                }
            }

            while(!q.isEmpty()) {
                int cur = q.poll();
                List<Integer> curList = list.get(cur);
                visited[cur] = 1;

                if(cur==last) break;

                for(int j=0;j<curList.size();j++){
                    int next = curList.get(j);
                    indegree[next]--;
                    construction[next] = Math.max(construction[next], construction[cur]+time[next]);

                    if(indegree[next]==0 && visited[next] == 0){
                        q.add(next);
                    }
                }
            }
            System.out.println(construction[last]);

        }
    }
}