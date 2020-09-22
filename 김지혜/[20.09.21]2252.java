import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList();

        int[] comeNum = new int[n+1];
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            comeNum[b] ++;
        }
        for(int i=1;i<=n;i++){
            if(comeNum[i]==0) q.offer(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            if(q.isEmpty()) break;
            int cur = q.poll();
            sb.append(cur+" ");

            for(int j=0;j<arr.get(cur).size();j++){
                int next = arr.get(cur).get(j);
                comeNum[next]--;
                if(comeNum[next] == 0)
                    q.offer(next);

            }
        }
        bw.write(sb+"\n");
        bw.close();
        br.close();
    }
}