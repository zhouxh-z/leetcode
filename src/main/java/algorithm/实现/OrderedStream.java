package algorithm.实现;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedStream {
    private Map<Integer,String> MAP = new HashMap<>();
    private Integer PTR;
    public OrderedStream(int n) {
        this.PTR = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        this.MAP.put(idKey,value);
        idKey = this.PTR;
        while (this.MAP.containsKey(idKey)){
            String val = this.MAP.get(idKey);
            ans.add(val);
            idKey ++;
        }
        if (this.MAP.containsKey(this.PTR)){
            this.PTR = idKey;
        }
        return ans ;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "c"));
        System.out.println(orderedStream.insert(1, "a"));
        System.out.println(orderedStream.insert(2, "b"));
        System.out.println(orderedStream.insert(5, "e"));
        System.out.println(orderedStream.insert(4, "d"));
    }
}