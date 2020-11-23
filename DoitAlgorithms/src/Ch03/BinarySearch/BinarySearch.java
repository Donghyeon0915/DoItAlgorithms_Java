/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch03.BinarySearch;

/**
 *
 * @author cyber
 */
public class BinarySearch {

    /*
    * 요솟수가 n인 배열 array에서 key와 같은 요소를 이진 검색
     */
    public static int binarySearch(int[] array, int key) {
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
                return array[mid];
            }
        } while (first <= last);
        
        return -1;
    }
}
