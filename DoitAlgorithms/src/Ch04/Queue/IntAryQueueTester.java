/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.Queue;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class IntAryQueueTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        IntAryQueue que = new IntAryQueue(5);
        
        while(true){
            System.out.println("\n현재 데이터 수 : " + que.size() + "/" + que.capacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 검색 (6) 초기화 (0) 종료 : ");
            int select = scan.nextInt();
            
            switch(select){
                case 1:
                    System.out.print("인큐할 데이터를 입력하세요 : ");
                    try{
                        que.enque(scan.nextInt());
                    }catch(IntAryQueue.OverflowIntQueueException e){
                        System.out.print("큐가 가득 찼습니다.\n");
                    }
                    break;
                case 2:
                    try{
                        System.out.print("디큐한 데이터 : " + que.deque());
                    }catch(IntAryQueue.EmptyIntQueueException e){
                        System.out.print("큐가 비어있습니다.\n");
                    }
                    break;
                case 3:
                    try{
                        System.out.print("피크한 데이터 : " + que.peek());
                    }catch(IntAryQueue.EmptyIntQueueException e){
                        System.out.print("큐가 비어있습니다.\n");
                    }
                    break;
                case 4:
                    que.dump();
                    break;
                case 5:
                    System.out.print("검색할 데이터를 입력하세요 : ");
                    int result = que.indexOf(scan.nextInt());
                    if(result >= 0) System.out.print("해당 데이터는 que[" + result + "]에 있습니다.\n");
                    else System.out.print("해당 데이터가 존재하지 않습니다.\n");
                    break;
                case 6:
                    que.clear();
                    break;
                case 0:
                    System.out.print("프로그램을 종료합니다.\n");
                    return;
            }
        }
    }
    
}
