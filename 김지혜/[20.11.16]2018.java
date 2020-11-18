import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sum;
        int answer = 0;
        for(int i=1;i<=n;i++){
            sum = 0;
            for(int j=i;j<=n && sum<n;j++){
                sum = sum+j;
            }
            if(sum==n) answer++;
        }
        System.out.println(answer);

    }

}