package collection;

import java.util.*;
import java.util.List;

public class main {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("name" + i);
        }
        System.out.println("arrayList \n\r" + arrayList);

        SortedSet sortedSet = new TreeSet<Integer>();
        for (int i = 0; i < 10; i++) {
            sortedSet.add("name" + i);
        }
        System.out.println("sortedSet \n\r" + sortedSet);

        TreeSet<String> treeSet = new TreeSet<String>();
        for (int i = 0; i < 10; i++) {
            treeSet.add("name" + i);
        }
        System.out.println("treeSet \n\r" + treeSet );

        //Хорош для поиска дубликатов
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 10; i++) {
            hashSet.add("name" + i);
        }
        System.out.println("hashSet \n\r" + hashSet);

        List<Integer> integerList = new ArrayList<Integer>();




    }
}
