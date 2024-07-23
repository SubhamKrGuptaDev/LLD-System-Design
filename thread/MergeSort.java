package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MergeSort implements Callable<List<Integer>> {

    int[] arr;
    int left;
    int mid;
    int m;

    public MergeSort(int[] arr, int left, int mid, int m) {
        this.arr = arr;
        this.left = left;
        this.mid = mid;
        this.m = m;
    }

    @Override
    public List<Integer> call() throws Exception {
        int i = left;
        int right = mid + 1;
        int n = mid;

        List<Integer> list = new ArrayList<>();
        while(left <= n && right <= m) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        while(left <= n) {
            list.add(arr[left]);
            left++;
        }
        while(right <= m) {
            list.add(arr[right]);
            right++;
        }

        for(int x : list) {
            arr[i++] = x;
        }
        System.out.println("Thread Name : "+ Thread.currentThread().getName());
        return list;
    }
}
