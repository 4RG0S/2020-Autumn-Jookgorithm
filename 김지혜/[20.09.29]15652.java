import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scan.nextInt();
        int m = scan.nextInt();

        backtracking(n, m, new int[n+1], 0);
        bw.close();
    }
    public static void backtracking(int n, int m, int[] input, int count) throws IOException {
        if(count==m){
            String output = "";
            for(int i=0;i<m;i++){
                if(i>0 && input[i-1]>input[i]) return;
                else{
                    output = output+input[i]+" ";
                }
            }
            bw.write(output+"\n");
        }
        else{
            for(int i=1;i<=n;i++){
                input[count] = i;
                backtracking(n, m, input, count+1);
            }
        }
    }

}