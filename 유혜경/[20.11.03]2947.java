import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int i = 0, j = 1;
        while(arr[0]!=1||arr[1]!=2||arr[2]!=3||arr[3]!=4||arr[4]!=5){
            if(i==4&&j==5) {i=0;j=1;}
            if(arr[i] > arr[j]){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                for(int k = 0; k < 5; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
            }
            i++; j++;
        }
    }
}