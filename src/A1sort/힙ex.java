package A1sort;

import java.util.Arrays;


public class 힙ex {
    public static void main(String[] args) {

        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);    // ***
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);    //***
        }
        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int arrLength, int node) {
        int left = node * 2 + 1;
        int right = node * 2 + 2;

        if (left > arrLength) {
            return;
        }
        if (right > arrLength) {
            swap(arr, arrLength, left);
            heapify(arr, arrLength, left);
        }
        if (arr[node] > arr[left] && arr[left] > arr[right]) {
            swap(arr, node, right);
            heapify(arr, arrLength, right);
        }
        if (arr[node] > arr[right] && arr[node] < arr[left]) {
            swap(arr, node, left);
            heapify(arr, arrLength, left);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//    static void heapify(int[] arr, int heapSize, int rootIndex) {
//        int largest = rootIndex;
//        int leftChild = 2 * rootIndex + 1;
//        int rightChild = 2 * rootIndex + 2;
//
//        // 왼쪽 자식 노드가 루트보다 크다면
//        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
//            largest = leftChild;
//        }
//
//        // 오른쪽 자식 노드가 가장 큰 노드보다 크다면
//        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
//            largest = rightChild;
//        }
//
//        // 가장 큰 노드가 루트가 아니라면
//        if (largest != rootIndex) {
//            swap(arr, rootIndex, largest);
//            heapify(arr, heapSize, largest);
//        }
//  }


}
