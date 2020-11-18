import java.io.IOException;
import java.util.Scanner;

public class Main {

    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        sb = new StringBuffer();
        int n = scan.nextInt();
        while(n!=0){
            int[] input = new int[n];
            for(int i=0;i<n;i++){
                input[i] = scan.nextInt();
            }
            backtracking(input, n, new boolean[n], 0, new int[n]);
            System.out.println(sb);
            sb = new StringBuffer();
            n = scan.nextInt();
        };
    }
    public static void backtracking(int[] input, int n, boolean[] visited, int count, int[] arr){
        if(count==6){
            String output = "";
            for(int i=0;i<6;i++){
                if(i>=1 && arr[i-1]>arr[i]) return;
                output = output+arr[i]+" ";
            }
            sb.append(output+"\n");
        }else{
            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                visited[i] = true;
                arr[count] = input[i];
                backtracking(input, n, visited, count+1, arr);
                visited[i] = false;
            }
        }
    }

}