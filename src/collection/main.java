package collection;

import java.util.*;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // List
        System.out.println("//_ List _//");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("name" + i);
        }
        arrayList.add("name777" );
        System.out.println("_ arrayList _ \n\r" + arrayList);

        LinkedList<String> linkedList = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            linkedList.add("name" + i);
        }
        linkedList.add("name777" );
        System.out.println("_ linkedList _ \n\r" + linkedList);

        // Set
        System.out.println("//_ Set _//");
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < 10; i++) {
            hashSet.add("name" + i);
        }
        hashSet.add("name777" );
        System.out.println("_ hashSet _ \n\r" + hashSet);
        for (String s : hashSet) {
            System.out.print(s.hashCode() + ", ");
        }

        TreeSet<String> treeSet = new TreeSet<String>();
        for (int i = 0; i < 10; i++) {
            treeSet.add("name" + i);
        }
        treeSet.add("name777" );
        System.out.println("_ treeSet _ \n\r" + treeSet );

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (int i = 0; i < 10; i++) {
            linkedHashSet.add("name" + i);
        }
        linkedHashSet.add("name777" );
        System.out.println("_ linkedHashSet _ \n\r" + linkedHashSet );
    }
}
