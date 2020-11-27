import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        int sum = 0;
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for(int i = 0; i < n; i++)
            sum += a[i] * b[i];
        System.out.println(sum);
    }
}