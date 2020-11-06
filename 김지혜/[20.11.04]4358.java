import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>();
        int numOfTree = 0;
        while(scan.hasNextLine()){
            String input = scan.nextLine();
            if(input.equals("")) break;

            hashMap.put(input, hashMap.getOrDefault(input, 0)+1);
            numOfTree++;
        }
        Set<String> set = hashMap.keySet();
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            double a = (double)hashMap.get(list.get(i))/(double)numOfTree*100;
            System.out.println(list.get(i)+" "+String.format("%.4f", a));
        }
    }
}