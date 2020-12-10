import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class HomeWork{
        int score;
        int time;
        public HomeWork(int score, int time){
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        Stack<HomeWork> stack = new Stack<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            String isHomeWork = st.nextToken();
            int curScore = 0;
            int curTime = 0;
            if(isHomeWork.equals("1")){
                curScore = Integer.parseInt(st.nextToken());
                curTime = Integer.parseInt(st.nextToken());
            }
            else{
                if(stack.isEmpty()) continue;
                HomeWork curHomeWork = stack.pop();
                curScore = curHomeWork.score;
                curTime = curHomeWork.time;
            }
            if(curTime==1) sum = sum + curScore;
            else{
                stack.push(new HomeWork(curScore, curTime-1));
            }
        }
        System.out.println(sum);


    }

}