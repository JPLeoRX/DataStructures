package com.tekleo.data_structures;

import com.tekleo.data_structures.collections.lists.linked_lists.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> s = new SinglyLinkedList<>();
        s.add("one");
        s.add("two");
        s.add("three");

        s.add(0, "hello");
        s.add(3, "last");

        System.out.println(s.size());
        for (String str : s) {
            System.out.println(str);
        }
    }
}
