/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.DoubleStack;

import Ch04.DoubleStack.DoubleStack.StackA;
import Ch04.DoubleStack.DoubleStack.StackB;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class DoubleStackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        DoubleStack dStack = new DoubleStack(10);
        StackA stkA = dStack.getStackA();
        StackB stkB = dStack.getStackB();
        int choice;
        
        while(true){
            System.out.print("\n현재 데이터 수 : " );
            System.out.println((stkA.size() + stkB.size()) + "/" + dStack.max + " \nA 스택 : " + stkA.size() + "\nB 스택 : " + stkB.size());
            
            System.out.print("(1) 푸쉬 (2) 팝 (3) 피크 (4) 덤프 (5) 검색 (6) 초기화 (0) 종료 : ");
            int select = scan.nextInt();
            
            // switch문 두 개(a,b) 안 만들고 한 번에 할 수 있는 방법 생각해보기
            // 제네릭처럼 선택된 타입으로 객체 생성?
            
            switch(select){
                case 1:
                    System.out.print("(1) A에 푸쉬 (2) B에 푸쉬 : ");
                    choice = scan.nextInt();
                    System.out.print("푸쉬할 데이터 : ");
                    
                    switch(choice){
                        case 1: 
                            try{
                                stkA.push(scan.nextInt());
                            }catch(DoubleStack.OverflowStackException e){
                                System.out.println("스택 A가 가득 차 있습니다.");
                            }
                            break;
                        case 2:
                            try{
                                stkB.push(scan.nextInt());
                            }catch(DoubleStack.OverflowStackException e){
                                System.out.println("스택 B가 가득 차 있습니다.");
                            }
                            break;
                    }
                    break;
                    
                case 2:
                    System.out.print("(1) A에서 팝 (2) B에서 팝 : ");
                    choice = scan.nextInt();
                    
                    switch(choice){
                        case 1:
                            try{
                                stkA.pop();
                            }catch(DoubleStack.EmptyStackException e){
                                System.out.print("스택 A가 비어있습니다.\n");
                            }
                            break;
                        case 2:
                            try{
                                stkB.pop();
                            }catch(DoubleStack.EmptyStackException e){
                                System.out.println("스택 B가 비어있습니다.");
                            }
                            break;
                    }
                    break;
                
                case 3:
                    System.out.print("(1) A에서 피크 (2) B에서 피크 : ");
                    choice = scan.nextInt();
                    
                    switch(choice){
                        case 1:
                            try{
                                System.out.print("피크한 데이터 : " + stkA.peek());
                            }catch(DoubleStack.EmptyStackException e){
                                System.out.println("스택 A가 비어있습니다.");
                            }
                            break;
                        case 2:
                            try{
                                System.out.print("피크한 데이터 : " + stkB.peek());
                            }catch(DoubleStack.EmptyStackException e){
                                System.out.println("스택 B가 비어있습니다.");
                            }
                            break;
                    }
                    break;
                
                case 4:
                    System.out.print("스택 A : ");
                    stkA.dump();
                    System.out.println("");
                    
                    System.out.print("스택 B : ");
                    stkB.dump();
                    break;
                
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }
    
}
