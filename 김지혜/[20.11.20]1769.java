import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();

        int count = 0;
        while(inputStr.length()>1){
            int sum = 0;
            for(int i=0;i<inputStr.length();i++){
                sum = sum + Integer.parseInt(inputStr.charAt(i)+"");
            }
            inputStr = String.valueOf(sum);
            count++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(count+"\n");
        if(Integer.parseInt(inputStr+"")%3==0) bw.write("YES\n");
        else bw.write("NO\n");

        br.close();
        bw.close();
    }
}