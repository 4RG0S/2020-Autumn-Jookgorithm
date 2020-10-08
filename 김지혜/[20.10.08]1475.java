import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String n = scan.next();

        int[] num = new int[10];
        for(int i=0;i<n.length();i++){
            int tmp = Integer.parseInt(n.charAt(i)+"");
            num[tmp] ++;
        }
        int max = num[6]+num[9];
        max = (max+1)/2;

        for(int i=0;i<10;i++){
            if(i==6 || i==9) continue;
            max = Math.max(num[i], max);
        }
        System.out.println(max);
    }

}
