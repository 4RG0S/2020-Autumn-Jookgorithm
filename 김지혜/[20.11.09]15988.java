import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        long[] input = new long[1000001];
        input[0] = 0; input[1] = 1; input[2] = 2; input[3] = 4;

        for(int i=4;i<1000001;i++){
            input[i] = input[i-3]+input[i-2]+input[i-1];
            input[i] = input[i]%1000000009;
        }
        int n = scan.nextInt();

        for(int i=0;i<n;i++){
            int a = scan.nextInt();
            System.out.println(input[a]);
        }
    }
}