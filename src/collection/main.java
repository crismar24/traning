package collection;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add("name" + i);
        }



        TreeSet<String> treeSet = new TreeSet<String>();

        for (int i = 0; i < 7; i++) {
            treeSet.add("name" + i);
        }

        System.out.println( list.containsAll(treeSet) );

        //Хорош для поиска дубликатов
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 10; i++) {
            hashSet.add("name" + i);
        }

        System.out.println(hashSet.containsAll(list));

    }
}
