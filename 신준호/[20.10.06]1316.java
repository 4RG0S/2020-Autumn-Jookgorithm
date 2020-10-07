import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        int t = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int tc = 0; tc < t; tc++) {
            input = br.readLine();
            boolean[] checker = new boolean[26];


            int i;
            for(i = 0; i < input.length(); i++) {

                if(checker[input.charAt(i) - 'a'])
                    break;
                else {
                    checker[input.charAt(i) - 'a'] = true;
                    int next = i + 1;
                    if(next == input.length()) continue;
                    while(input.charAt(i) == input.charAt(next)) {
                        next++;
                        i++;
                        if(next == input.length()) break;
                    }
                }
            }

            if(i == input.length()) cnt++;

        }

        System.out.print(cnt);

    }


}
