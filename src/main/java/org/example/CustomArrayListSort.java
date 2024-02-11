package org.example;

import java.util.Comparator;

/**
 * Класс CustomArrayListSort предоставляет методы сортировки объектов CustomList с использованием алгоритма быстрой сортировки.
 */
public class CustomArrayListSort {
    /**
     * Сортирует элементы в CustomList с использованием алгоритма быстрой сортировки и заданного компаратора.
     *
     * @param list       CustomList, который требуется отсортировать
     * @param leftIndex  индекс левой границы текущего раздела
     * @param rightIndex индекс правой границы текущего раздела
     * @param c          компаратор для определения порядка элементов
     * @param <E>        тип элементов в CustomList
     */

    public static <E> void quicksort(CustomList<E> list, int leftIndex, int rightIndex, Comparator<? super E> c) {
        if (leftIndex < rightIndex) {
            // Выбраем опорный элемент (mid)
            int mid = (leftIndex + rightIndex) / 2;
            E pivot = list.get(mid);
            // Устанавливаем маркеры для левого и правого индекса
            int leftMarkerIndex = leftIndex;
            int rightMarkerIndex = rightIndex;
            // Разделяем list на подмассивы, который больше и меньше опорного элемента
            while (leftMarkerIndex <= rightMarkerIndex) {
                // Перемещяем leftMarkerIndex вправо, если элемент меньше, чем pivot
                while (c.compare(list.get(leftMarkerIndex), pivot) < 0) {
                    leftMarkerIndex++;
                }
                // Перемещяем rightMarkerIndex влево, если элемент меньше, чем pivot
                while (c.compare(list.get(rightMarkerIndex), pivot) > 0) {
                    rightMarkerIndex--;
                }
                // Меняем элементы местами, если leftMarkerIndex до сих пор <= rightMarkerIndex
                if (leftMarkerIndex <= rightMarkerIndex) {
                    // Сохраняю элемент слева в переменную swap и меняю местами с переменной по индексу rightIndex
                    E swap = list.get(leftMarkerIndex);
                    list.set(leftMarkerIndex, list.get(rightMarkerIndex));
                    list.set(rightMarkerIndex, swap);
                    // Передвигаю индексы элементов, чтобы получить новые границы
                    leftMarkerIndex++;
                    rightMarkerIndex--;
                }
            }
            if (leftIndex < rightMarkerIndex) {
                quicksort(list, leftIndex, rightMarkerIndex, c);
            }
            if (rightIndex > leftMarkerIndex) {
                quicksort(list, leftMarkerIndex, rightIndex, c);
            }
        }
    }

    public static <E extends Comparable<? super E>> void quicksort(CustomList<E> list, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Выбраем опорный элемент (mid)
            int mid = (leftIndex + rightIndex) / 2;
            E pivot = list.get(mid);
            // Устанавливаем маркеры для левого и правого индекса
            int leftMarkerIndex = leftIndex;
            int rightMarkerIndex = rightIndex;
            // Разделяем list на подмассивы, который больше и меньше опорного элемента
            while (leftMarkerIndex <= rightMarkerIndex) {
                // Перемещяем leftMarkerIndex вправо, если элемент меньше, чем pivot
                while ((list.get(leftMarkerIndex).compareTo(pivot)) < 0) {
                    leftMarkerIndex++;
                }
                // Перемещяем rightMarkerIndex влево, если элемент меньше, чем pivot
                while ((list.get(rightMarkerIndex).compareTo(pivot)) > 0) {
                    rightMarkerIndex--;
                }
                // Меняем элементы местами, если leftMarkerIndex до сих пор <= rightMarkerIndex
                if (leftMarkerIndex <= rightMarkerIndex) {
                    // Сохраняю элемент слева в переменную swap и меняю местами с переменной по индексу rightIndex
                    E swap = list.get(leftMarkerIndex);
                    list.set(leftMarkerIndex, list.get(rightMarkerIndex));
                    list.set(rightMarkerIndex, swap);
                    // Передвигаю индексы элементов, чтобы получить новые границы
                    leftMarkerIndex++;
                    rightMarkerIndex--;
                }
            }
            if (leftIndex < rightMarkerIndex) {
                quicksort(list, leftIndex, rightMarkerIndex);
            }
            if (rightIndex > leftMarkerIndex) {
                quicksort(list, leftMarkerIndex, rightIndex);
            }
        }
    }
}