import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) System.out.println(1);
        else {
            int s = 1, e = 2, sum = s + e, cnt = 0;
            while (s <= n && e <= n) {
                if (sum > n) {
                    sum -= s;
                    s++;
                } else if (sum < n) {
                    e++;
                    sum += e;
                } else {
                    sum -= s;
                    s++;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}