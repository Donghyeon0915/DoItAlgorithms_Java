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
public class SortAPI {

    public static void printArray(int[] array) {

        for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }

    public static int[] getTestCase(int n, int first, int end) {
        int[] TestCase = new int[n];
        //System.out.println("들어오나");
        if (first > end) {
            int temp = first;
            first = end;
            end = temp;
        }

        for (int i = 0; i < n; i++) {
            TestCase[i] = (int) (Math.random() * (end - first + 1)) + first;
        }

        return TestCase;
    }
    
    public static boolean sortCheck(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) return false;
        }
        return true;
    }
    
    public static void swap(int[] array, int idx1, int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
