package kr1;

import Spiski.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(2);
        list1.add(3);
        list1.add(6);
        list1.add(1);
        list1.print(); // Вывод: 2 3 6 1
        list1.remove(2);
        list1.print(); // Вывод: 2 1 3
        list1.sort();
        list1.print();
        list1.clear();
    }
}
