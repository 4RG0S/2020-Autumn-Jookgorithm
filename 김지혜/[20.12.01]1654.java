import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long[] input = new long[n];
        long max = 0;
        for(int i=0;i<n;i++){
            input[i] = scan.nextInt();
            max = Math.max(max, input[i]);
        }
        long left = 1;
        long right = max;
        long maxLength = 0;
        while(left<=right){
            long curNum = 0;
            long midLength = (left+right)/2;

            for(int i=0;i<n;i++){
                curNum = curNum + input[i]/midLength;
            }
            if(curNum<m){
                right = midLength-1;
            }
            else{
                left = midLength+1;
                maxLength = Math.max(maxLength, midLength);
            }
        }
        System.out.println(maxLength);

    }
}
