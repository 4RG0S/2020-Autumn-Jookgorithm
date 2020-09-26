import javafx.scene.input.DataFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static int[][] dp;

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String[] tokens;

        //input = br.readLine();
        //tokens = input.split(" ");

        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");

            String name = tokens[0];
            String day = tokens[1];
            String month = tokens[2];
            String year = tokens[3];

            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
            String form = year + "-" + month + "-" + day;
            Date date = dataFormat.parse(form);

            people[i] = new Person(name, date.getTime());
        }

        Arrays.sort(people, Comparator.comparingLong(o -> o.birthday));

        System.out.println(people[people.length - 1].name);
        System.out.println(people[0].name);

    }

    public static class Person {
        String name;
        long birthday;

        Person(String name, long birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

}
