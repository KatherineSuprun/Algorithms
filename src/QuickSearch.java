public class QuickSearch {

    public static int search(int arr[], int x)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // Если элемент найден возвращает индекс
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
