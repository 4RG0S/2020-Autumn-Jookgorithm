import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] input = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            input[i] = scan.nextInt();
            max = Math.max(max, input[i]);
        }
        long answerMax = 0;
        long left = 0; long right = max;

        while(left<=right){
            long mid = (left+right)/2;
            long sum = 0;
            for(int i=0;i<n;i++){
                sum = sum+Math.max(input[i]-mid, 0);
            }
            if(sum >= m){
                answerMax = Math.max(answerMax, mid);
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answerMax);

    }
}