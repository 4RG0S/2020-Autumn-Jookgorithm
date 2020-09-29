import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] input = new int[n];
        maybeBacktracking(n, m, input, 0);
        bw.close();

    }
    public static void maybeBacktracking(int n, int m, int[] input, int count) throws IOException {
        if(count==m){
            for(int i=0;i<m;i++){
                bw.write(input[i]+" ");
            }
            bw.write("\n");
        }
        for(int i=1;i<=n && n>count;i++){
            input[count] = i;
            maybeBacktracking(n, m, input, count+1);
        }
    }



}