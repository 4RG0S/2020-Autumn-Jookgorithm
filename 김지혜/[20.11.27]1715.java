import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(scan.nextInt());
        }
        int sum = 0;
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b);
            sum = sum+a+b;
        }
        System.out.println(sum);
    }

}