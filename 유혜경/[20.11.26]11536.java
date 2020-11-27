import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = scan.next();
        }
        boolean inc = true,dec = true;
        for(int i = 1; i < n; i++){
            if(str[i-1].compareTo(str[i]) > 0) inc = false;
            if(str[i-1].compareTo(str[i]) < 0) dec = false;
        }
        if(inc) System.out.println("INCREASING");
        else if(dec) System.out.println("DECREASING");
        else System.out.println("NEITHER");
    }
}