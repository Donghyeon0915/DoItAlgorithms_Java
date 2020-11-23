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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1, 9, 2, 9, 4, 6, 7, 9};
        int[] idx = new int[array.length];
        
        System.out.println(SearchIdx.searchIdx(array, 8, 9, idx));
        
        
    }
    
}
