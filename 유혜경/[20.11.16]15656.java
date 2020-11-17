import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder str = new StringBuilder();
    static boolean[] visit;
    static int[] arr;
    static int[] seq;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visit = new boolean[n+1];
        arr = new int[n+1];
        seq = new int[n+1];
        for(int i = 1; i < n+1; i++)
            seq[i] = scanner.nextInt();
        Arrays.sort(seq);
        dfs(n,m,0);
        System.out.println(str);
    }
    private static void dfs(int n, int m, int cnt){
        if(cnt == m){
            for(int i = 0; i < cnt; i++)
                str.append(arr[i]+" ");
            str.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            arr[cnt] = seq[i];
            dfs(n,m,cnt+1);
        }
        return ;
    }
}