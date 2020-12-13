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
public class SelectionSort {

    /**
     * @param array
     * @return 
     */
    
    public static int[] selectionSort(int[] array){
        int length = array.length;
        int i, j;
        
        for (i = 0; i < length - 1; i++) {
            int min = i;
            for (j = i + 1; j < length; j++) {
                if(array[j] < array[min]){
                    min = j;
                }
            }
            
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        
        return array;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        
        for (int i : selectionSort(array)) {
            System.out.println(i);
        }
    }

}
