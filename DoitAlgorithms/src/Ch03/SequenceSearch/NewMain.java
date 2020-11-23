/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch03.SequenceSearch;

import java.util.Scanner;

/**
 *
 * @author cyber
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1,2,5,7,10,15,20,30,46,59,60,64,67,69,70,73,74,77,79,80,83,85,87,89};
        Scanner stdin = new Scanner(System.in);
        System.out.print("찾을 데이터를 입력하세요 : ");
        
        int key = stdin.nextInt();
        int keyIndex = SeqSearch.seqSearch_Q2(array, array.length - 1, key);
        
        if(keyIndex >= 0)System.out.println(key + "는 array[" + keyIndex + "]에 있습니다.");
        else System.out.println("찾는 데이터가 없습니다.");
        
    }
    
}
