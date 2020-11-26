import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(scan.nextInt());
            }
        }
        for(int i=0;i<n-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }

}