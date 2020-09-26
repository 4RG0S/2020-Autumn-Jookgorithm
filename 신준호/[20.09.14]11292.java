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

        while(!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            Student[] students = new Student[n];

            for(int i = 0; i < n; i++) {
                tokens = br.readLine().split(" ");
                students[i] = new Student(tokens[0], Double.parseDouble(tokens[1]));
            }

            Comparator<Student> comp = Comparator.comparingDouble(o -> o.height);
            Arrays.sort(students, comp.reversed());

            System.out.print(students[0].name + " ");
            for(int i = 1; i < students.length; i++) {
                if(students[i].height == students[0].height) System.out.print(students[i].name + " ");
                else break;
            }

            System.out.println();

        }


    }

    public static class Student {
        String name;
        double height;

        Student(String name, double height) {
            this.name = name;
            this.height = height;
        }
    }

}
