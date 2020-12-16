package Ch06.Sort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Donghyeon <20183188>
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    
    /*
    * 버블 정렬
    * 이웃한 원소와 패스(비교, 교환)를 수행
    */
    // 패스(pass) : 비교, 교환 작업
    public static int[] bubbleSort2(int[] array) {
        int length = array.length;
        /*
        * 마지막 교환이 이루어진 곳의 뒷 부분은 이미 정렬이 되었다고 판단
        * 따라서, 시작부터 마지막 교환이 이루어진 부분까지만 탐색
        */
        for (int i = length - 1; i > 0; i--) {
            int last = length;      
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    last = j;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            i = last;
        }
        
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        //특정 패스에서 교환이 이루어지지 않으면 이미 정렬이 된 것이므로 더이상 탐색할 필요가 없다.

        for (int i = 0; i < length; i++) {
            boolean swap = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!swap) {
                break;
            }
        }

//        for (int i = 0; i < length - 1; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if(array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
        return array;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (int i : bubbleSort2(array)) {
            System.out.println(i);
        }
    }

}
