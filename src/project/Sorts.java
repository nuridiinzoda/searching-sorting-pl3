package project;

public class Sorts {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Quicksort (O(n log n))
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void selectionSort(CountingInt[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j].compareTo(arr[minIdx]) < 0) {
                minIdx = j;
            }
        }
        CountingInt temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
    }
}

public static void insertionSort(CountingInt[] arr) {
    for (int i = 1; i < arr.length; i++) {
        CountingInt key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j].compareTo(key) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

public static void quickSort(CountingInt[] arr) {
    quickSort(arr, 0, arr.length - 1);
}

private static void quickSort(CountingInt[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private static int partition(CountingInt[] arr, int low, int high) {
    CountingInt pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j].compareTo(pivot) <= 0) {
            i++;
            CountingInt temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    CountingInt temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
    return i + 1;
}

public static void mergeSort(CountingInt[] arr) {
    mergeSort(arr, 0, arr.length - 1);
}

private static void mergeSort(CountingInt[] arr, int left, int right) {
    if (left >= right) return;
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private static void merge(CountingInt[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    CountingInt[] L = new CountingInt[n1];
    CountingInt[] R = new CountingInt[n2];

    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i].compareTo(R[j]) <= 0) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}

}
