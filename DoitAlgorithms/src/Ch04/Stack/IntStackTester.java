/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.Stack;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class IntStackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        IntStack stack = new IntStack(64); //최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("\n현재 데이터 수 : " + stack.size() + "/" + stack.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 "
                           + "(5) 검색 (6) 초기화 (0) 종료 : ");
            int select = scan.nextInt();

            switch (select) {
                case 1:
                    System.out.print("푸시할 데이터를 입력하세요 : ");
                    try {
                        stack.push(scan.nextInt());
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        stack.pop();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 3:
                    try{
                        System.out.println(stack.peek());
                    }catch(IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 4:
                    stack.dump();
                    break;
                case 5:
                    System.out.print("검색할 데이터를 입력하세요 : ");
                    int result = stack.indexOf(scan.nextInt());
                    if(result >= 0)System.out.println((result + 1) + "번 째에 있습니다.");
                    else System.out.println("찾는 데이터가 없습니다.");
                    break;
                case 6:
                    stack.clear();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

}
