/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch03.SequenceSearch;

/**
 *
 * @author cyber
 */
public class SeqSearch {
    //선형 검색(보초법) - Sentinel Method 

    /*
    * 요솟수가 n인 배열 array에서 key와 같은 요소를 보초법으로 선형 검색
    * 데이터를 찾으면 해당 데이터의 인덱스 리턴
     */
    public static int seqSearch(int[] array, int n, int key) {
        array[n] = key;
        int i;

        for (i = 0; i < n; i++) {
            if (array[i] == key) {
                break;
            }
        }
        return i == n ? -1 : i;
    }

    public static int seqSearch_Q2(int[] array, int n, int key) {
        array[n] = key;
        int i;

        System.out.printf("    | ");
        for (int j = 0; j <= n; j++) {
            if(array[j] >= 10 && j < 10) System.out.print(j + "   ");
            else System.out.print(j + "  ");
        }

        System.out.print("\n----+-");
        for (int j = 0; j < n; j++) {
            System.out.print("----");
        }
        System.out.println();

        for (i = 0; i <= n; i++) {
            printCurrent(i, array);
            if (array[i] == key) {
                break;
            }
        }
        return i == n ? -1 : i;
    }

    public static void printCurrent(int index, int[] array) {
        int curIndex = 0;
        
        System.out.print("    | ");
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                System.out.print("*\n");
            }
            else if(i > index) break;
            else {
                if(array[i] >= 10)System.out.print("    ");
                else System.out.print("   ");
            }
        }
        System.out.printf("%2d  | ", index);
        for (int i = 0; i < array.length; i++) {
            
            if (array[i] >= 10) {
                System.out.printf("%-4d", array[i]);
            } else {
                System.out.printf("%-3d", array[i]);
            }
        }
        System.out.println();
    }
}
