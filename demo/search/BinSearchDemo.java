package search;

/**
 * BinSearch
 */
public class BinSearchDemo {

    static Integer binSearch(Integer[] arr, Integer x) {
        Integer mid = null;
        Integer low = 0;
        Integer hight = arr.length - 1;
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (x == arr[mid])
                return mid;
            else if (x > arr[mid])
                low = mid + 1;
            else
                hight = mid - 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = 10 * i;
        }
        Integer index = binSearch(arr, 100);
        System.out.println(index);
    }
}
