/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch03.SequenceSearch.Question3;

/**
 *
 * @author Donghyeon <20183188>
 */
public class SearchIdx {
    /*
    * 요솟수가 n인 배열에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고,
    * 일치한 요솟수를 반환하는 메서드
    */
    public static int searchIdx(int[] array, int n, int key, int[] idx){
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] == key){
                idx[index++] = i;
            }
        }
        
        return index;
    }
}
