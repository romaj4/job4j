package ru.job4j.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDiv {

    public Integer[][] arrayDivision(int[] arr) {
        Arrays.sort(arr);
        int sum1 = 0;
        int sum2 = 0;
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (sum1 <= sum2) {
                list1.add(arr[i]);
                sum1 += arr[i];
            } else {
                list2.add(arr[i]);
                sum2 += arr[i];
            }
        }
        int diff = Math.abs(sum1 - sum2);
        if (diff > 1) {
            if (sum1 > sum2) {
                changeSubject(list1, list2, diff);
            } else {
                changeSubject(list2, list1, diff);
            }
        }
        return new Integer[][]{list1.toArray(new Integer[list1.size()]), list2.toArray(new Integer[list1.size()])};
    }

    public void changeSubject(List<Integer> list1, List<Integer> list2, int diff) {
        boolean finish = false;
        for (int i = 0; i < list1.size() && !finish; i++) {
            for (int j = 0; j < list2.size(); j++) {
                int diffNum = list1.get(i) - list2.get(j);
                if (diffNum > 0 && diffNum < diff) {
                    int temp = list1.get(i);
                    list1.set(i, list2.get(j));
                    list2.set(j, temp);
                    finish = true;
                    break;
                }
            }
        }
    }
}
