public class MergeSort {


    public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

        int[] sorted = new int[one.length + two.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {

            if (one[i] < two[j]) {
                sorted[k] = one[i];
                k++;
                i++;
            } else {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (i == one.length) {

            while (j < two.length) {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (j == two.length) {

            while (i < one.length) {
                sorted[k] = one[i];
                k++;
                i++;
            }
        }

        return sorted;

    }

    void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();

    }
}
