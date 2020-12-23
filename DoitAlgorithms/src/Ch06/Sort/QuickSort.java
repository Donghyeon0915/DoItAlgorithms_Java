/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch06.Sort;

import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    // left(start) : 정렬을 시작하는 부분 집합의 첫 번째
    // right(end) : 정렬을 시작하는 부분 집합의 마지막

    public static void quickSort(int[] data, int left, int right) {
        if(left >= right) return;                               // 요소가 1개인 경우
        
        int pl = left;                                          // 왼쪽 커서    (그룹으로 나눠진 배열의 시작과 끝을 나타냄)
        int pr = right;                                         // 오른쪽 커서
        int pivot = data[(pl + pr) / 2];                        // 중간 값을 pivot으로 지정

        do {
            while (data[pl] < pivot) pl++;                      // 왼쪽에선 pivot보다 큰 값을 찾을때까지
            while (data[pr] > pivot) pr--;                      // 오른쪽에선 pivot보다 작은 값을 찾을때까지
  
            if (pl <= pr) SortAPI.swap(data, pl++, pr--);       // 엇갈리지 않은 경우 data[pl]과 data[pr]을 교체
                                                                // 이미 지나온 값은 pivot보다 작거나(왼쪽) 크므로(오른쪽) 다음 데이터부터 탐색                                                             
        } while (pl <= pr);                                     // pl과 pr이 엇갈리는 경우는 pivot을 기점으로 엇갈리게 된다.

        quickSort(data, left, pr);                              // pl과 pr이 엇갈리게 되면 pivot 기준으로 pl은 오른쪽으로, pr은 왼쪽으로 가게 된다. (혹은 pivot과 같은 위치)
        quickSort(data, pl, right);                             // 따라서, 왼쪽 그룹의 범위는 left ~ pr, 오른쪽 그룹의 범위는 pl ~ right가 된다.
        
        /*
                quickSort(data, pl, pr);                        잘못 된 경우 (무한 루프)
                quickSort(data, pr, data.length - 1);           
         */
    }
    
    public static void quickSort_NoRecur(int[] data, int left, int right){
        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();
        
        lStack.push(left);                                          // 그룹의 시작(왼쪽)
        rStack.push(right);                                         // 그룹의 끝(오른쪽)
        
        while(!lStack.isEmpty()){
            int pl = left = lStack.pop();
            int pr = right = rStack.pop();
            int pivot = data[(left + right) / 2];
            
            do{
                while(data[pl] < pivot) pl++;
                while(data[pr] > pivot) pr--;
                
                if(pl <= pr) SortAPI.swap(data, pl++, pr--);
            }while(pl <= pr);
            
            
            if(left < pr){
                lStack.push(left);                                  // == quickSort(data, left, pr);
                rStack.push(pr);
            }
            if(right > pl){
                lStack.push(pl);                                    // == quickSort(data, pl, right);
                rStack.push(right);
            }
        }

    }

    
    static void partition(int[] data, int n) {
        int pl = 0;                                 // 왼쪽 커서
        int pr = n - 1;                             // 오른쪽 커서
        int pivot = data[n / 2];                    // 피벗(중간 값)
        System.out.println("피벗 : " + pivot);
        do {
            while (data[pl] < pivot) {
                pl++;           // 피벗 값보다 큰 값을 찾을 때까지 반복 (왼쪽 -> 오른쪽)
            }
            while (data[pr] > pivot) {
                pr--;           // 피벗 값보다 작은 값을 찾을 때까지 반복 (오른쪽 -> 왼쪽)
            }
            if (pl <= pr) {                           // 엇갈리지 않은 경우
                SortAPI.swap(data, pl++, pr--);     // 이미 지나온 pl, pr에 대해선 pivot보다 크거나(pl) 작음(pr)이 확실하므로 다름 데이터부터 탐색
            }
        } while (pl <= pr);

        print_Partition(data, pl, pr);
    }

    public static void print_Partition(int[] data, int pl, int pr) {
        int n = data.length;

        System.out.println("피벗 이하의 그룹 : ");
        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");

        if (pl > pr + 1) {
            System.out.println("피벗과 일치하는 그룹 : ");
            for (int i = pr + 1; i <= pl - 1; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println("");
        }

        System.out.println("피벗 이상의 그룹 : ");
        for (int i = pr + 1; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        // TODO code application logic here
        // {5, 7, 1, 4, 6, 6, 6, 2, 3, 9, 8};
        //  {1, 8, 7, 4, 5, 2, 6, 3, 9};
        int[] array = SortAPI.getTestCase(10, 0, 50);
        
        SortAPI.printArray(array);
        //partition(array, array.length);
        
        quickSort(array, 0, array.length - 1);
        SortAPI.printArray(array);
        
//        quickSort2(array, 0, array.length - 1);
//        SortAPI.printArray(array);
//        System.out.println(SortAPI.sortCheck(array));
    }

}
