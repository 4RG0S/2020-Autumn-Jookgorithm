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

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1.end > o2.end)
                return 1;
            else if(o1.end < o2.end)
                return -1;
            else
                return Integer.compare(o2.len, o1.len);
        });

        int cnt = 1;
        Meeting prev = meetings[0];
        for(int i = 1; i < meetings.length; i++) {
            if(prev.end <= meetings[i].start) {
                cnt++;
                prev = meetings[i];
            }
        }

        System.out.println(cnt);

    }

    public static class Meeting {
        int start;
        int end;
        int len;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end - start;
        }
    }

}
