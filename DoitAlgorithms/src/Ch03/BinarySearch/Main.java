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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1,2,5,7,10,15,20,30,46,59,60,64,67,69,70,73,74,77,79,80,83,85,87,89};
        int[] randArray = new int[1000];
        
        randArray[0] = 0;
        for (int i = 1; i < randArray.length; i++) {
            randArray[i] = randArray[i - 1] + (int)(Math.random() * 9);
        }
        
        System.out.println(BinarySearch.binarySearch(array, 69));
    }
    
}
