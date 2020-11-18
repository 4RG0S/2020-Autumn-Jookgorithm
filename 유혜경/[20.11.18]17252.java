import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int check = 0;
        if(n==0) check = 1;
        while(n > 1){
            if(n%3 > 1) {
                check = 1;
                break;
            }
            n /= 3;
        }
        if(check == 1) System.out.println("NO");
        else System.out.println("YES");
    }
}