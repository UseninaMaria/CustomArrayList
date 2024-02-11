package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    private CustomArrayList<Integer> customArrayListInt;
    private CustomArrayList<Person> customArrayListPerson;
    private Person person;
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUpInt() {
        customArrayListInt = new CustomArrayList<>();
    }

    @BeforeEach
    void setUpIntPrs() {
        customArrayListPerson = new CustomArrayList<>();
    }

    @BeforeEach
    void setUpPerson() {
        person = new Person(12, "Misha");
        person1 = new Person(25, "Masha");
        person2 = new Person(32, "Ivan");
    }

    @Test
    void returnsZeroWhenEmptyListInt() {
        assertEquals(0, customArrayListInt.size());
    }

    @Test
    void addsElementToEndOfListInt() {
        customArrayListInt.add(5);

        assertEquals(1, customArrayListInt.size());
        assertEquals(5, customArrayListInt.get(0));
    }

    @Test
    void addsElementAtSpecifiedIndexInt() {
        customArrayListInt.add(0, 1);
        customArrayListInt.add(1, 3);
        customArrayListInt.add(1, 2);

        assertEquals(3, customArrayListInt.size());
        assertEquals(1, customArrayListInt.get(0));
        assertEquals(2, customArrayListInt.get(1));
        assertEquals(3, customArrayListInt.get(2));
    }

    @Test
    void returnsElementAtIndexInt() {
        customArrayListInt.add(1);
        customArrayListInt.add(2);

        assertEquals(2, customArrayListInt.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayListInt.get(2));
    }

    @Test
    void setReplacesElementAtIndexInt() {
        customArrayListInt.add(1);
        customArrayListInt.set(0, 5);

        assertEquals(5, customArrayListInt.get(0));
    }

    @Test
    void removesElementAtIndexInt() {
        customArrayListInt.add(1);
        customArrayListInt.add(2);

        assertEquals(2, customArrayListInt.size());
        assertEquals(2, customArrayListInt.remove(1));
        assertEquals(1, customArrayListInt.size());
    }

    @Test
    void baseSortsElementsInListInt() {
        customArrayListInt.add(3);
        customArrayListInt.add(1);
        customArrayListInt.add(2);
        customArrayListInt.sort(Comparator.naturalOrder());

        assertEquals(1, customArrayListInt.get(0));
        assertEquals(2, customArrayListInt.get(1));
        assertEquals(3, customArrayListInt.get(2));
    }

    @Test
    void removesAllElementsInt() {
        customArrayListInt.add(1);
        customArrayListInt.add(2);
        customArrayListInt.clear();

        assertEquals(0, customArrayListInt.size());
    }

    @Test
    void returnsZeroWhenEmptyListP() {
        assertEquals(0, customArrayListPerson.size());
    }

    @Test
    void sizeAfterAddsElementsP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        customArrayListPerson.add(person2);

        assertEquals(3, customArrayListPerson.size());
    }

    @Test
    void addsElementToEndOfListP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        customArrayListPerson.add(person2);

        Person testPerson = customArrayListPerson.get(0);

        assertEquals("Misha", testPerson.name);
        assertEquals(12, testPerson.age);
    }

    @Test
    void addsElementAtSpecifiedIndexP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        customArrayListPerson.add(person2);

        Person testPerson = customArrayListPerson.get(0);
        Person testPerson1 = customArrayListPerson.get(1);
        Person testPerson2 = customArrayListPerson.get(2);

        assertEquals(3, customArrayListPerson.size());

        assertEquals("Misha", testPerson.name);
        assertEquals(12, testPerson.age);

        assertEquals("Masha", testPerson1.name);
        assertEquals(25, testPerson1.age);

        assertEquals("Ivan", testPerson2.name);
        assertEquals(32, testPerson2.age);
    }

    @Test
    void indexGetExceptionP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);

        assertThrows(IndexOutOfBoundsException.class, () -> customArrayListPerson.get(2));
    }

    @Test
    void replacesElementAtIndexP() {
        customArrayListPerson.add(person);
        customArrayListPerson.set(0, person1);

        Person testPerson = customArrayListPerson.get(0);

        assertEquals(person1, customArrayListPerson.get(0));
    }

    @Test
    void removesElementAtIndexP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        assertEquals(2, customArrayListPerson.size());
        assertEquals(person1, customArrayListPerson.remove(1));
        assertEquals(1, customArrayListPerson.size());
    }

    @Test
    void baseSortsElementsInListP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person2);
        customArrayListPerson.add(person1);
        customArrayListPerson.sort(Comparator.naturalOrder());

        assertEquals(person, customArrayListPerson.get(0));
        assertEquals(person1, customArrayListPerson.get(1));
        assertEquals(person2, customArrayListPerson.get(2));
    }

    @Test
    void removesAllElementsP() {
        customArrayListPerson.add(person);
        customArrayListPerson.add(person1);
        customArrayListPerson.add(person2);
        customArrayListPerson.clear();
        assertEquals(0, customArrayListPerson.size());
    }
}
