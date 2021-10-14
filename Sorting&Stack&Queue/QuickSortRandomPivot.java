public class QuickSortRandomPivot {
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }

    }

    public int partition(int[] a, int low, int high) {
        int pivot = (int) (Math.random() * a.length + 1);
        int boundary = low - 1;

        for (int i = low; i < high; i++) {
            if (a[i] < a[pivot]) {
                boundary++;
                swap(a, i, boundary);
            }
        }
        swap(a, boundary, pivot);
        return boundary + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
