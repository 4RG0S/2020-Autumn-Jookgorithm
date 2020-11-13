import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(f(b) - f(a-1));
    }
    static long f(long l){
        long s = l;
        for(long i = 2; i <= l; i*=2) s += (l/i)*(i/2);
        return s;
    }
}