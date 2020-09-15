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

        Score[] scores = new Score[8];
        for(int i = 0; i < 8; i++)
            scores[i] = new Score(i + 1, Integer.parseInt(br.readLine()));

        Arrays.sort(scores, Comparator.comparingInt(o -> o.score));
        int sum = 0;
        for(int i = 3; i < 8; i++)
            sum += scores[i].score;
        System.out.println(sum);

        Score[] tmp = new Score[5];
        for(int i = 3; i < 8; i++)
            tmp[i-3] = scores[i];

        Arrays.sort(tmp, Comparator.comparingInt(o -> o.id));
        for(int i = 0; i < 5; i++)
            System.out.print(tmp[i].id + " ");

    }

    public static class Score {
        int id;
        int score;

        Score(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }


}
