/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch03.BinarySearch;

/**
 *
 * @author Donghyeon <20183188>
 */
public class BinarySearchFirst {
    /*
    * key 값과 같은 값이 제일 처음 나오는 인덱스를 반환
    */
    public static int binarySearchFirst(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;
        
        do {
            if(array[mid] < key){
                first = mid + 1;
                mid = (first + last) / 2;
            }
            else if(array[mid] > key){
                last = mid - 1;
                mid = (first + last) / 2;
            }
            else{
                System.out.print("find data\n");
                while(true){
                    if(mid > 0){
                        if(array[mid] != array[mid - 1]) return mid;
                        else mid--;
                    }
                }
            }
        } while (first <= last);
        
        return -1;
    }
}
