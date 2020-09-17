import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(sb.readLine());
            HashMap<String, String> map = new HashMap<>();
            HashMap<String, Integer> childMap = new HashMap<>();

            for(int j=0;j<m;j++){
                String input = sb.readLine();
                st = new StringTokenizer(input);
                String personA = st.nextToken();
                String personB = st.nextToken();

                union(map, childMap, personA, personB);
                bw.write(childMap.get(find(map, personA))+"\n");
            }
        }
        bw.close();
        sb.close();
    }
    public static void union(HashMap<String, String> hashMap, HashMap<String, Integer> childMap,
                             String personA, String personB){

        if(!hashMap.containsKey(personA) && !hashMap.containsKey(personB)){
            hashMap.put(personA, personA);
            hashMap.put(personB, personA);
            childMap.put(personA, 2);
        }
        else if(!hashMap.containsKey(personA)){
            personB = find(hashMap, personB);
            hashMap.put(personA, personB);
            childMap.put(find(hashMap, personB), childMap.get(personB)+1);
        }
        else if(!hashMap.containsKey(personB)){
            personA = find(hashMap, personA);
            hashMap.put(personB, personA);
            childMap.put(find(hashMap, personA), childMap.get(personA)+1);
        }
        else {
            personA = find(hashMap, personA);
            personB = find(hashMap, personB);
            if(!personA.equals(personB)) {
                hashMap.put(personB, personA);
                childMap.put(find(hashMap, personA), childMap.get(personA) + childMap.get(personB));
            }
        }
    }
    public static String find(HashMap<String, String> hashMap, String person){
        if(hashMap.get(person).equals(person)) return person;
        return find(hashMap, hashMap.get(person));
    }

}