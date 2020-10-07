import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int length = (int)Math.pow(2, n)-1;
        int[] input = new int[length];

        for(int i=0;i<length;i++){
            input[i] = scan.nextInt();
        }
        int[] visited = new int[length];
        list = new LinkedList[n+1];
        for(int i=0;i<n+1;i++){
            list[i] = new LinkedList<>();
        }
        printTree(input, visited, 0, length-1, 0, length);
        for(int i=0;i<n+1;i++){
            for(int j=0;j<list[i].size();j++){
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void printTree(int[] input, int[] visited, int start, int end, int depth, int length){
        if(start<0 || end>=length || start>end) return;
        int i = start+(end-start)/2;
        if(i>length || i<0 || visited[i] == 1) return;
        visited[i] = 1;
        list[depth].add(input[i]);
        depth++;
        printTree(input, visited, start, i, depth, length);
        printTree(input, visited, i+1, end, depth, length);
    }
}
