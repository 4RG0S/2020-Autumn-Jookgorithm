import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<People> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken()) * 100;
            int year = Integer.parseInt(st.nextToken()) * 10000;
            list.add(new People(name, year+month+day));
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1).name);
        System.out.println(list.get(0).name);
    }
    static class People implements  Comparable<People>{
        String name;
        int birth;
        public People(String name, int birth){
            this.name = name;
            this.birth = birth;
        }
        @Override
        public int compareTo(People p){
            if(this.birth < p.birth) return -1;
            else if(this.birth > p.birth) return 1;
            return 0;
        }
    }
}