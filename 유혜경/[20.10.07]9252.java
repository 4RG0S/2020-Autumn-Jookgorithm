import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] table = new int[str2.length()+1][str1.length()+1];
        for(int i = 0; i <= str2.length(); i++){
            table[i][0] = 0;
            for(int j = 1; j <= str1.length(); j++){
                if(i == 0) table[i][j] = 0;
                else if(str2.charAt(i-1)==str1.charAt(j-1))
                    table[i][j] = table[i-1][j-1]+1;
                else
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
            }
        }
        System.out.println(table[str2.length()][str1.length()]);
        String str = "";
        int i = str2.length();
        int j = str1.length();
        while(i>=1&&j>=1){
            if(table[i][j] == table[i-1][j]) i--;
            else if(table[i][j] == table[i][j-1]) j--;
            else{
                str = str2.charAt(i-1) + str;
                i--; j--;
            }
        }
        System.out.println(str.toString());
    }
}