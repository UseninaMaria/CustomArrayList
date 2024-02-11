package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListSortTest {

    private CustomArrayList<Integer> customArrayList;
    private CustomArrayList<Person> customArrayListPerson;
    private Person person;
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(4);
        customArrayList.add(1);
        customArrayList.add(5);
    }

    @BeforeEach
    void setUpPerson() {
        customArrayListPerson = new CustomArrayList<>();

        person = new Person(12, "Misha");
        person1 = new Person(8, "Masha");
        person2 = new Person(32, "Ivan");

        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        customArrayListPerson.add(person2);
    }

    @Test
    void quicksortComparatorInt() {
        CustomArrayListSort.quicksort(customArrayList, 0, customArrayList.size() - 1, Comparator.naturalOrder());

        assertEquals(1, customArrayList.get(0));
        assertEquals(1, customArrayList.get(1));
        assertEquals(3, customArrayList.get(2));
        assertEquals(4, customArrayList.get(3));
        assertEquals(5, customArrayList.get(4));
    }

    @Test
    public void quicksortComparableInt() {
        CustomArrayListSort.quicksort(customArrayList, 0, customArrayList.size() - 1);

        assertEquals(1, customArrayList.get(0));
        assertEquals(1, customArrayList.get(1));
        assertEquals(3, customArrayList.get(2));
        assertEquals(4, customArrayList.get(3));
        assertEquals(5, customArrayList.get(4));
    }

    @Test
    void quicksortComparatorPrs() {
        CustomArrayListSort.quicksort(customArrayListPerson, 0, customArrayListPerson.size() - 1, Comparator.naturalOrder());

        assertEquals(person1, customArrayListPerson.get(0));
        assertEquals(person, customArrayListPerson.get(1));
        assertEquals(person2, customArrayListPerson.get(2));
    }

    @Test
    void quicksortComparablePrs() {
        CustomArrayListSort.quicksort(customArrayListPerson, 0, customArrayListPerson.size() - 1);

        assertEquals(person1, customArrayListPerson.get(0));
        assertEquals(person, customArrayListPerson.get(1));
        assertEquals(person2, customArrayListPerson.get(2));
    }
}
