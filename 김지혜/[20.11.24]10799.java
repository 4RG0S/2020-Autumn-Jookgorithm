import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        Stack<Character> stack = new Stack();

        int cur = 0;
        int sum = 0;
        char prev = 0;
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(!stack.isEmpty() && c==')' && prev =='('){
                cur--;
                sum = sum + cur;
                stack.pop();
            }else if(c=='('){
                stack.push(c);
                cur++;
            }else{
                cur--;
                sum++;
                stack.pop();
            }
            prev = c;
        }
        while(!stack.isEmpty()){
            sum++;
            stack.pop();
        }
        System.out.println(sum);
    }
}