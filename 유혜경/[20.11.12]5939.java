import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            list.add(i, new Time(h, m, s));
        }
        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.h != o2.h) return o1.h - o2.h;
                else if(o1.m != o2.m) return o1.m - o2.m;
                else return o1.s - o2.s;
            }
        });
        for (int i = 0; i < n; i++)
            System.out.println(list.get(i).h+" "+list.get(i).m+" "+list.get(i).s);
    }
    static class Time{
        int h;
        int m;
        int s;
        public Time(int h, int m, int s){
            this.h = h;
            this.m = m;
            this.s = s;
        }
    }
}