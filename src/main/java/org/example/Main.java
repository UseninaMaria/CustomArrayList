package org.example;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
//         Работа CustomList с Integer
        CustomList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(6);
        System.out.println(list);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(1);
        System.out.println(list);
        CustomArrayListSort.quicksort(list, 0, list.size() - 1, Comparator.naturalOrder());
        System.out.println(list);

        //         Работа CustomList с String
        CustomList<String> list1 = new CustomArrayList<>();
        list1.add("Саша");
        list1.add("Маша");
        System.out.println(list1);
        list1.add("Даша");
        list1.add("Оля");
        list1.add("Иван");
        list1.add("Коля");
        System.out.println(list1);
        CustomArrayListSort.quicksort(list1, 0, list1.size() - 1, Comparator.naturalOrder());
        System.out.println(list1);

        //         Работа CustomList с Person
        Person person = new Person(12, "Misha");
        Person person1 = new Person(25, "Masha");
        Person person2 = new Person(32, "Ivan");
        CustomList<Person> list2 = new CustomArrayList<>();
        list2.add(person);
        list2.add(person1);
        list2.add(person2);
        System.out.println(list2);
        list2.sort(Comparator.naturalOrder());
        CustomArrayListSort.quicksort(list2, 0, list2.size() - 1);
        System.out.println(list2);
    }
}