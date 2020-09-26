import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) ->{
            int t1 = Math.abs(o1);
            int t2 = Math.abs(o2);
            if(t1==t2) return o1 - o2;
            return t1 - t2;
        });
        int tmp;
        for(int i = 0; i < n; i++){
            tmp = Integer.parseInt(br.readLine().trim());
            if(tmp == 0){
                if(q.isEmpty()) System.out.println(0);
                else System.out.println(q.remove());
            }
            else q.add(tmp);
        }
    }
}