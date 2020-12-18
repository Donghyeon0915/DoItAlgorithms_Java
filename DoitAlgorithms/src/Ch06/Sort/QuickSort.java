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
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    // start : 정렬을 시작하는 부분 집합의 첫 번째
    // end : 정렬을 시작하는 부분 집합의 마지막
    
    public static void quickSort2(int[] data, int start, int end){
        if(start >= end){ // 원소가 1개일 때
            return;
        }
        
        int pivot = start;
        int pl = start + 1;
        int pr = end;
        
        while(pl <= pr){                                        //엇갈릴 때까지 반복
            while(pl <= end && data[pl] <= data[pivot]){        //피벗보다 큰 값을 찾을 때까지 왼쪽 -> 오른쪽
                pl++;
            }
            while(pr > start && data[pr] >= data[pivot]){       // 피벗보다 작은 값을 찾을 때까지 오른쪽 -> 왼쪽
                                                                //pr이 배열의 왼쪽 끝을 넘어가는 경우를 방지
                pr--;
            }
            if(pl > pr)SortAPI.swap(data, pr, pivot);           //현재 엇갈린 상태면 키 값과 교체
            else SortAPI.swap(data, pr, pl);
        }
        
        quickSort2(data, start, pr - 1);
        quickSort2(data, pr + 1, end);
    }
    
    static void partition(int[] data, int n){
        int pl = 0;                                 // 왼쪽 커서
        int pr = n - 1;                             // 오른쪽 커서
        int pivot = data[n / 2];                    // 피벗(중간 값)
        System.out.println("피벗 : " + pivot);
        do{
            while(data[pl] < pivot) pl++;           // 피벗 값보다 큰 값을 찾을 때까지 반복 (왼쪽 -> 오른쪽)
            while(data[pr] > pivot) pr--;           // 피벗 값보다 작은 값을 찾을 때까지 반복 (오른쪽 -> 왼쪽)
            if(pl <= pr){                           // 엇갈리지 않은 경우
                SortAPI.swap(data, pl++, pr--);     // 이미 지나온 pl, pr에 대해선 pivot보다 크거나(pl) 작음(pr)이 확실하므로 다름 데이터부터 탐색
            }
        }while(pl <= pr);
        
        System.out.println("피벗 이하의 그룹 : ");
        for (int i = 0; i < pl; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
        
        System.out.println("피벗과 일치하는 그룹 : ");
        for (int i = pr + 1; i < pl; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
        
        System.out.println("피벗 이상의 그룹 : ");
        for (int i = pr + 1; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] array = SortAPI.getTestCase(10, 0, 50);
        SortAPI.printArray(array);
        partition(array, 10);
//        quickSort2(array, 0, array.length - 1);
//        SortAPI.printArray(array);
//        System.out.println(SortAPI.sortCheck(array));
    }
    
}
