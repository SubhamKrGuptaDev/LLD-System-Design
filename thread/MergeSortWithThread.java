package thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortWithThread {
    static ExecutorService executor;
    public static void main(String[] args) {
        int[] arr = {3,2,14,8,9,7,6,5,2,3,4,1,9,6,2,54,12,89,12,23,12,21,13,14,52,9,7,8,65,3,2,132,98,76,4,65,34};
        executor = Executors.newFixedThreadPool(3);
        try {
            mergeSort(arr, 0, arr.length - 1);
            for (int list : arr) {
                System.out.print(list + " ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static void mergeSort(int[] arr, int left, int right) throws ExecutionException, InterruptedException {
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int m) throws ExecutionException, InterruptedException {
        MergeSort merge = new MergeSort(arr, left, mid, m);
        Future<List<Integer>> futureList = executor.submit(merge);

        List<Integer> sortedList = futureList.get();

        for(int x : sortedList) {
            arr[left++] = x;
        }

    }

}
