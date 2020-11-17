import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int k;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[k];
        for(int i = 0; i < k; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        re(0);
        System.out.println(max);
    }
    static void re(int i){
        if(i > n) return;
        max = Math.max(i, max);
        for(int j = k-1; j >= 0; j--)
            re(i*10 + arr[j]);
    }
}