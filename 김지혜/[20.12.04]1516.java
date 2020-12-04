import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        boolean[][] building = new boolean[n+1][n+1];

        int[] timeArr = new int[n+1];
        int[] preArr = new int[n+1];
        for(int i=1;i<=n;i++){
            int time = scan.nextInt();
            timeArr[i] = time;
            int input = scan.nextInt();
            while(input!=-1){
                preArr[i]++;
                building[input][i] = true;
                input = scan.nextInt();
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] realTimeArr = new int[n+1];
        for(int i=1;i<=n;i++){
            if(preArr[i]==0) q.add(i);
            realTimeArr[i] = timeArr[i];
        }
        boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i=1;i<=n;i++){
                if(building[cur][i] && !visited[i]){
                    preArr[i]--;
                    realTimeArr[i] = Math.max(realTimeArr[i], timeArr[i]+realTimeArr[cur]);
                    if(preArr[i]==0 && !visited[i]) q.add(i);
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println(realTimeArr[i]);
        }


    }
}
