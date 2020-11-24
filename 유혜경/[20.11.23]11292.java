import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            if(n==0)break;
            ArrayList<Person> l = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String s = scanner.next();
                double h = scanner.nextDouble();
                l.add(new Person(s,h));
            }
            Collections.sort(l, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return Double.compare(o1.height, o2.height);
                }
            });
            for(int i = 0;i < l.size(); i++){
                if(l.get(i).height != l.get(l.size()-1).height) continue;
                System.out.print(l.get(i).name+" ");
            }
            System.out.println();
        }
    }
    static class Person{
        String name;
        double height;
        public Person(String n, double h){
            this.name = n;
            this.height = h;
        }
    }
}