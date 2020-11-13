import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int max_cnt=1;
        long max_value= 0;
        
        for (int i = 0; i < n; i++) 
        {
            long key = Long.parseLong(sc.next());
            if(map.containsKey(key))
            {
                int val = map.get(key)+1;
                map.put(key,val);
                if(max_cnt == map.get(key))
                {
                    max_value= Math.min(max_value, key);
                }
                else if(max_cnt < map.get(key))
                {
                    max_cnt=map.get(key);
                    max_value = key;
                }
            }
            else 
            {
                map.put(key,1);
                if(map.size()==1)
                {
                    max_value = key;
                }
                if(max_cnt  ==1)
                {
                    max_value = Math.min(max_value, key);
                }
            }
        }
        System.out.println(max_value);
    }
}
