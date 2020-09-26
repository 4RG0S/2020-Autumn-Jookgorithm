import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] coin = new int[n+1];
        coin[0] = 0; coin[1] = -1;
        for(int i = 2; i <= Math.min(4, n); i++){
            if(coin[i-2] == -1) coin[i] = -1;
            else coin[i] = coin[i-2] + 1;
        }
        for(int i = 5; i <= n; i++){
            if(coin[i-2] == -1 && coin[i-5] == -1) coin[i] = -1;
            else if(coin[i-2] == -1) coin[i] = coin[i-5]+1;
            else if(coin[i-5] == -1) coin[i] = coin[i-2]+1;
            else coin[i] = Math.min(coin[i-2], coin[i-5])+1;
        }
        System.out.println(coin[n]);
    }
}