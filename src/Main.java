import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Быстрая сортировка делит большой массив на два меньших подмассива,
        // а затем рекурсивно сортирует подмассивы.  Ο(log n)
        int arr[] = {2, 3, 4, 10, 40};

        int x = 10;

        int result = QuickSearch.search(arr, x);
        if (result == -1) {
            System.out.print("Quick Search. Element " + x + " is not found in array.");
        } else {
            System.out.print("Quick Search. Element " + x + " is found"
                    + " at index: " + result);
        }
        // Сортировка слиянием делит входной массив на две половины, вызывает себя
        // для двух половин, а затем объединяет две отсортированные половины.  O(n log2 n)
        arr = new int[]{12, 11, 13, 5, 6, 7};

        System.out.println("\n*******************************");
        System.out.println("Merge Search. Given array is:");
        MergeSort.printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("*******************************");
        System.out.println("Sorted array is:");
        MergeSort.printArray(arr);

        // Бинарный поиск производится в отсортированном массиве путём
        // деления массива на половины
        int[] A = {4, 6, 8, 10, 15};
        int key = 10;

        int index = Arrays.binarySearch(A, key);

        if (index >= 0) {
            System.out.println("*******************************");
            System.out.println("Binary Search. Element is found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
        System.out.println("*******************************");
        String[] inputSequence = {"Paris", "Rom", "Venice", "Istanbul",
                "Rio de Janeiro", "New York", "Amsterdam", "Prague"};

        EulerPath solution = new EulerPath(inputSequence);
        String startNode = solution.getStartNode(inputSequence);
        solution.findEulerPath(startNode);
        Collections.reverse(solution.result);
        System.out.println(solution.result);
    }

}


