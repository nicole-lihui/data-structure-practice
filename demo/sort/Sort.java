package sort;

/**
 * SimpleSelectionSort
 */
public class Sort {

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void arrSwap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void selectionSort(int[] arr) {
        int minv, min;
        for (int i = 0; i < arr.length; i++) {
            minv = arr[i];
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minv) {
                    minv = arr[j];
                    min = j;
                }
            }
            if (min != i) {
                arrSwap(arr, i, min);
                System.out.print(i + ": ");
                printArr(arr);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int x;
        for (int i = 1, j; i < arr.length; i++) {
            x = arr[i];
            for (j = i; j > 0 && arr[j - 1] > x; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = x;
            System.out.print(i + ": ");
            printArr(arr);
        }
    }

    public static void bubbleSort(int[] arr) {
        int flag = 1;
        for (int i = 0; flag == 1 && i < arr.length; i++) {
            flag = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arrSwap(arr, j, j + 1);
                    flag = 1;
                }
            }
            System.out.print(i + ": ");
            printArr(arr);
        }
    }

    public static void precolateDown(int k, int[] arr, int size) {
        int x = arr[k];
        int i, child;
        for (i = k; i * 2 + 1 < size; i = child) {
            child = i * 2 + 1;
            if (child != size - 1 && arr[child + 1] > arr[child])
                child++;
            if (arr[i] < arr[child] || x < arr[child])
                arr[i] = arr[child];
            else
                break;
        }
        arr[i] = x;
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            precolateDown(i, arr, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            arrSwap(arr, 0, i);
            precolateDown(0, arr, i);
            System.out.print(arr.length - 1 - i + ": ");
            printArr(arr);
        }
    }

    public static void msort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        msort(arr, tmp, left, mid);
        msort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, mid + 1, right);
    }

    public static void merge(int[] arr, int[] t, int li, int ri, int re) {
        int le, ti, beginLi;
        beginLi = ti = li;
        le = ri - 1;
        while (li <= le && ri <= re) {
            if (arr[li] <= arr[ri])
                t[ti++] = arr[li++];
            else
                t[ti++] = arr[ri++];
        }
        while (li <= le)
            t[ti++] = arr[li++];
        while (ri <= re)
            t[ti++] = arr[ri++];
        for (int i = beginLi; i <= re; i++)
            arr[i] = t[i];
    }

    public static void mergeSort(int[] arr) {
        int[] t = new int[arr.length];
        msort(arr, t, 0, arr.length - 1);
    }

    public static int medianPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid])
            arrSwap(arr, left, mid);
        if (arr[left] > arr[right])
            arrSwap(arr, left, right);
        if (arr[mid] > arr[right])
            arrSwap(arr, mid, right);
        arrSwap(arr, mid, right - 1);

        return arr[right - 1];
    }

    public static void qInsertionSort(int[] arr, int begin, int size) {
        int x;
        for (int i = begin + 1, j; i < size; i++) {
            x = arr[i];
            for (j = i; j > 0 && arr[j - 1] > x; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = x;
            System.out.print(i + ": ");
            printArr(arr);
        }
    }

    final static int cutoff = 3;

    public static void qSoct(int[] arr, int left, int right) {
        int pivot;
        if (right - left < cutoff) {
            qInsertionSort(arr, left, right + 1);
        } else {
            pivot = medianPivot(arr, left, right);
            int i, j;
            i = left + 1;
            j = right - 2;
            while (true) {
                while (arr[i] < pivot)
                    i++;
                while (arr[j] > pivot)
                    j--;
                if (i < j)
                    arrSwap(arr, i, j);
                else
                    break;
            }
            arrSwap(arr, i, right - 1);
            qSoct(arr, 22, i - 1);
            qSoct(arr, i + 1, right);
        }

    }

    public static void quickSort(int[] arr) {
        qSoct(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 11, 222, 3, 44, 55, 66, -100, 0, 999, 1234, 1 };
        printArr(arr);

        // selectionSort(arr);
        // insertionSort(arr);
        // bubbleSort(arr);
        // heapSort(arr);
        // mergeSort(arr);
        quickSort(arr);
        printArr(arr);

    }
}
