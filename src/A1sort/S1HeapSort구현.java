package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Collections.swap;

// 정렬 : n^2 이냐 nlogn 이냐
// 힙자료구조 : 우선순위 큐

// pq : add 상향식 heapify (log n) / poll ( log n) - > n log n
public class S1HeapSort구현 {
    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
//        for (int i = arr.length / 2 - 1; i >=0 ; i--) {
//            heapify(arr,arr.length-1, i);    // ***
//        }
//        for (int i = arr.length - 1; i >= 0; i--) {
//            swap(arr, i, 0);
//            heapify(arr, i-1, 0);    //***
//        }
//        System.out.println(Arrays.toString(arr));


//        int[] arr2 = {7, 6, 5, 8, 3, 5, 9, 1, 6};
//        Queue<Integer> pq = new PriorityQueue<>();
//        for(int a : arr2) {
//            pq.add(a);
//        }
//        System.out.println(pq);

        int k = 3;
//        int[] score = new int[7];
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        Queue<Integer> pq = new PriorityQueue<>();

        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.remove();
            }
            answer[i] = pq.peek();
        }


//        while(pq.size() < 8 && pq.isEmpty() == false) {
//            int count = 0;
//            pq.add(score[count]);
//            if(pq.size() > k ) {
//                pq.poll();
//            }
//            answer[count] = pq.peek();
//            count++;
//        }
        System.out.println(Arrays.toString(answer));
    }

    static void heapify(int[] arr, int arrLength, int node) {
        int left = node * 2 + 1;
        int right = node * 2 + 2;

        if (left > arrLength ){    // ***
            return;
        }
        if (right > arrLength) {
            swap(arr, arrLength, left);
            heapify(arr, arrLength, left);
        } else { /// ***
            int index = 0;
            if (arr[node] > arr[left] || arr[node] > arr[right]) {
                if (arr[left] > arr[right]) {
                    index = right;
                } else {
                    index = left;
                }
                swap(arr, node, index);
                heapify(arr, arrLength, index);
            }
        }
//        if (left>arrLength) {
//            return;
//        }
//        if (right>arrLength) {
//            swap(arr, arrLength, left);
//            heapify(arr, arrLength, left);
//        }
//        if (arr[node] > arr[left] && arr[left] > arr[right] ) {
//            swap(arr, node, right);
//            heapify(arr, arrLength, right);
//        }
//        if (arr[node] > arr[right] && arr[node] < arr[left] ) {
//            swap(arr, node, left);
//            heapify(arr, arrLength, left);
//        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
