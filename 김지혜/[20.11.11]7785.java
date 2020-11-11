import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<=n;i++){
            String input = scan.nextLine();
            if(input.equals("")) continue;

            String[] command = input.split(" ");
            if(command[1].equals("enter"))
                hashMap.put(command[0], 1);
            else
                hashMap.remove(command[0]);
        }
        ArrayList<String> arr = new ArrayList<>(hashMap.keySet());
        Collections.sort(arr, Collections.reverseOrder());
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }
}