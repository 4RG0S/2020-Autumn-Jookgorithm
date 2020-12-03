import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] input = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            input[i] = scan.nextInt();
            max = Math.max(input[i], max);
        }
        int m = scan.nextInt();

        int left = 1;
        int right = max;

        int maxBudget = 0;
        while(left<=right){
            int budget = (left+right)/2;
            int sum = 0;
            for(int i=0;i<n;i++){
                sum = sum + Math.min(budget, input[i]);
            }
            if(sum>m){
                right = budget-1;
            }
            else{
                left = budget+1;
                maxBudget = Math.max(maxBudget, budget);
            }
        }
        System.out.println(maxBudget);
    }
}
