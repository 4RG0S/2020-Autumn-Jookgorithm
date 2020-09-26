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
        int[] visited = new int[n];
        maybeBacktracking(n, m, input, visited, 0);
        bw.close();

    }
    public static void maybeBacktracking(int n, int m, int[] input, int[] visited, int count) throws IOException {
        if(count==m){
            if(!isCorrect(input, count)) return;
            for(int i=0;i<m;i++){
                bw.write(input[i]+" ");
            }
            bw.write("\n");
        }
        for(int i=1;i<=n;i++){
            if(visited[i-1] == 0){
                visited[i-1] = 1;
                input[count] = i;

                maybeBacktracking(n, m, input, visited, count+1);
                visited[i-1] = 0;
            }
        }
    }
    public static boolean isCorrect(int[] input, int count){
        int tmp = input[0];
        for(int i=1;i<count;i++){
            if(tmp>input[i]) return false;
            tmp = input[i];
        }
        return true;
    }



}