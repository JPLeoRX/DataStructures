package com.tekleo.data_structures;

public class Main {
    public static void main(String[] args) {
        MyCollection<String> s = new MyCollection<>("hello");

        System.out.println(s.toArray()[0]);
    }
}
