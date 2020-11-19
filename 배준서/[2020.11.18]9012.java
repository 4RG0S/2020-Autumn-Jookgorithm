import java.io.*;
import java.util.Stack;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<Character>();

        String input = "";
        String nStr = br.readLine();
        int n = Integer.parseInt(nStr);

        for (int i = 0; i < n; i++)
        {
            input = br.readLine();
            boolean noFlag = false;

            for (int j = 0; j < input.length(); j++)
            {
                if (input.charAt(j) == '(')
                {
                    stack.push(input.charAt(j));
                }
                else
                {
                    if (stack.empty())
                    {
                        noFlag = true;
                        break;
                    }
                    else
                    {
                        stack.pop();
                    }
                }
            }

            if (noFlag == false && stack.empty())
            {
                bw.write("YES" + '\n');
            }
            else if (noFlag == true || !stack.empty())
            {
                bw.write("NO" + '\n');
                stack.clear();
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }

}
