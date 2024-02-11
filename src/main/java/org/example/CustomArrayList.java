package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * CustomArrayList реализация интерфейса CustomList с изменяемым размером массива.
 * Реализует все необязательные операции со списками и разрешает все элементы, включая null .
 * Каждый экземпляр CustomArrayList имеет емкость . Емкость — это размер массива,
 * используемого для хранения элементов списка. Его размер всегда равен размеру списка.
 * По мере добавления элементов в CustomArrayList его емкость автоматически увеличивается.
 * @author Usenina Maria
 * @link <a href="https://github.com/UseninaMaria">...</a>
 * @param <E> тип элементов в списке
 */
public class CustomArrayList<E> implements CustomList<E> {
    /**
     * Начальная емкость по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Общий пустой экземпляр массива, используемый для пустых экземпляров.
     */
    private Object[] data;
    /**
     * Размер ArrayList (количество содержащихся в нем элементов).
     */
    private int size;

    /**
     * Конструктор создает пустой список с указанной начальной емкостью.
     *
     * @param capacity начальная емкость списка
     * @throws IllegalArgumentException – если указанная начальная емкость отрицательна
     */
    public CustomArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0 ");
        } else {
            data = new Object[capacity];
        }
    }

    /**
     * Конструктор создает пустой список с начальной емкостью десять.
     * И размером CustomArrayList ноль
     */
    public CustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Возвращает количество элементов в этом списке.
     *
     * @return количество элементов в этом списке
     */
    public int size() {
        return size;
    }

    /**
     * Добавляет указанный элемент в конец этого списка.
     *
     * @param element элемент, который будет добавлен в этот список
     */
    public void add(E element) {
        overCapacity(size + 1);
        data[size++] = element;
    }

    /**
     * Добавляет элемент в коллекцию по указанному индексу, сдвигая остальные элементы при необходимости.
     *
     * @param index   индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index > size())
     */
    public void add(int index, E element) {
        Objects.checkIndex(index, size + 1);
        overCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * Возвращает элемент из коллекции по указанному индексу.
     *
     * @param index индекс, по которому нужно получить элемент
     * @return элемент, расположенный по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size)
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) data[index];
    }

    /**
     * Заменяет элемент в коллекции по указанному индексу новым элементом.
     *
     * @param index   индекс, по которому нужно заменить элемент
     * @param element новый элемент, которым нужно заменить существующий
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size)
     */
    public void set(int index, E element) {
        Objects.checkIndex(index, size);
        data[index] = element;
    }

    /**
     * Удаляет элемент из коллекции по указанному индексу и возвращает удаленный элемент.
     *
     * @param index индекс элемента, который нужно удалить
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size)
     */
    public E remove(int index) {
        Objects.checkIndex(index, size);
        E oldValue = (E) data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
        return oldValue;
    }

    /**
     * Удаляет все элементы из коллекции и сбрасывает размер коллекции в 0.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует элементы в коллекции, используя указанный компаратор.
     *
     * @param c компаратор, используемый для сравнения элементов при сортировке
     */
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) data, 0, size, c);
    }

    /**
     * Увеличивает емкость внутреннего массива данных, если минимальная необходимая емкость превышает текущую емкость.
     *
     * @param minCapacity минимальная необходимая емкость
     */
    private void overCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity + (oldCapacity / 2);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(size).append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(data[i]).append(", ");
            }
            sb.append(data[size - 1]).append("]");
            return sb.toString();
        }
    }
}

