import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            map.put(tokens[0], tokens[1]);
        }

        List<String> list = new ArrayList<>();
        for(String name : map.keySet()) {
            if(map.get(name).equals("enter")) list.add(name);
        }

        list.sort(Comparator.reverseOrder());

        for (String s : list) System.out.println(s);

    }


}
