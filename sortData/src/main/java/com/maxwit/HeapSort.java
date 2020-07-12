package com.maxwit;

public class HeapSort {
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[j] ^ data[j];
    }

    public static void createMaxHeap(int[] data, int lastIndex) {
        int range = (lastIndex - 1) / 2;
        for (int i = range; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;

            }
        }

    }

    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {

        }
    }
}
