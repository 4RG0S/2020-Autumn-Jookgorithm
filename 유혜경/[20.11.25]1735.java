import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt();
        int b1 = scan.nextInt();
        int a2 = scan.nextInt();
        int b2 = scan.nextInt();
        int gcd = gcd(b1, b2);
        int top = ((a1*b2) +(a2*b1))/gcd;
        int bottom = (b1*b2)/gcd;
        gcd = gcd(top, bottom);
        System.out.println(top / gcd + " " + bottom / gcd);
    }
    public static int gcd(int x, int y){
        int tmp, n;
        if(x < y){
            tmp = x;
            x = y;
            y = tmp;
        }
        while(y != 0){
            n = x % y;
            x = y;
            y = n;
        }
        return x;
    }
}