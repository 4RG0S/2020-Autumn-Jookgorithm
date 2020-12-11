import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long left = 1;
        long right = k;

        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            long tmpCount = 0;

            for(int i=1;i<=n;i++){
                tmpCount = tmpCount + Math.min(n, mid/i);
            }
            if(tmpCount>=k){
                right = mid-1;
                answer = mid;
            }
            else{
                left = mid+1;
            }
        }
        bw.write(answer+"\n");
        br.close();
        bw.close();
    }

}