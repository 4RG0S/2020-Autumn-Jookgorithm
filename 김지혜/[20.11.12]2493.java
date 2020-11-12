import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class Top{
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        Stack<Top> stack = new Stack<>();
        Stack<Top> tmpStack = new Stack<>();
        for(int i=1;i<=n;i++){
            int cur = Integer.parseInt(st.nextToken());
            int target = 0;
            if(stack.empty()){
                stack.add(new Top(i, cur));
                bw.write(0+" ");
            }else{
                while(!stack.isEmpty() && stack.peek().height<cur){
                    tmpStack.push(stack.pop());
                }
                if(stack.isEmpty()) target=0;
                else target = stack.peek().index;

                bw.write(target+" ");
                stack.add(new Top(i, cur));
            }
        }
        br.close();
        bw.close();
    }

}