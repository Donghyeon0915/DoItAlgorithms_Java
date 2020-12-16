/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch06.Sort;

/**
 *
 * @author Donghyeon <20183188>
 */
public class InsertionSort {

    /*
    * 삽입 정렬
    * 각 숫자를 적절한 위치에 삽입
    * 정렬을 할 원소의 앞은 이미 정렬이 되어있다고 가정
    * 앞으로 탐색하면서 자신보다 작은 원소가 나올때까지 Swap
     */
    public static int[] insertionSort2(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int j;
            int tmp = array[i];
            // 왼쪽 끝에 도달했을경우, tmp보다 작거나 같은 값을 만났을경우를 만족할 때까지 반복
            // = j > 0 이고 a[j -1] > tmp 인 경우를 만족할 때까지 반복
            for (j = i; j > 0 && array[j - 1] > tmp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            //정렬할 원소보다 작은 원소가 나올때까지
            
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }

        }

        return array;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int[] test = {5, 2, 3, 4, 1};
        for (int i : insertionSort(test)) {
            System.out.println(i);
        }
    }

}
