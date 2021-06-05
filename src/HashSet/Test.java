package HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Test {
    public static void main(String args[]) {
        HashSet set = new HashSet();
        set.add("hello");
        set.add(1);
        set.add(1.033);
        System.out.println(set);

        LinkedList list = new LinkedList();
        list.offer("1");
        list.offer(1);
        list.offer(1.0003);
        System.out.println(list);
        
        ArrayList array = new ArrayList();
        array.add("1");
        array.add(1);
        array.add(1.035);
        System.out.println(array);
    }
}
