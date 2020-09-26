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

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            input = br.readLine();
            if(!map.containsKey(input))
                map.put(input, 1);
            else
                map.put(input, map.get(input) + 1);
        }

        for(int i = 0; i < n - 1; i++) {
            input = br.readLine();
            map.put(input, map.get(input) - 1);
            if(map.get(input) == 0)
                map.remove(input);
        }

        System.out.println(map.keySet().toArray()[0]);

    }


}
