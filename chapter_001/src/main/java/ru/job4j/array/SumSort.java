package ru.job4j.array;

/**
 * Отортироанный массив из двух отсортированных.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SumSort {

    /**
     * @param arr1 1-й отсортированный массив.
     * @param arr2 2-й отсортированный массив.
     * @return массив.
     */
    public int[] sumSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0, j = 0, k = 0; i < result.length; i++) {
            if (k >= arr2.length || (j < arr1.length && arr1[j] < arr2[k])) {
                result[i] = arr1[j++];
            } else {
                result[i] = arr2[k++];
            }
        }
        return result;
    }
}
