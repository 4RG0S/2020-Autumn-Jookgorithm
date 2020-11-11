import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0;i<input.length();i++){
            pq.add(input.substring(i));
        }
        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}