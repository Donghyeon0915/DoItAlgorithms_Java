/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.GenericStack;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class GstackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        Gstack<String> stack = new Gstack<>(String.class, 64);

        while (true) {
            System.out.println("\n현재 데이터 수 : " + stack.size() + "/" + stack.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 "
                    + "(5) 검색 (6) 초기화 (0) 종료 : ");
            int select = scan.nextInt();

            switch (select) {
                case 1:
                    System.out.print("푸쉬할 데이터를 입력하세요 : ");
                    try {
                        stack.push(scan.next());
                    } catch (RuntimeException e) {
                        System.out.print("스택이 가득차있습니다.\n");
                    }
                    break;

                case 2:
                    try {
                        stack.pop();
                    } catch (RuntimeException e) {
                        System.out.print("스택이 비어있습니다.\n");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("피크한 데이터는 " + stack.peek() + " 입니다.");
                    }catch(RuntimeException e){
                        System.out.print("스택이 비어있습니다.\n");
                    }
                    break;
                case 4:
                    stack.dump();
                    break;
                case 5:
                    System.out.print("검색할 데이터를 입력하세요 : ");
                    int pos = stack.indexOf(scan.next());
                    
                    if(pos >= 0) System.out.println("해당 데이터는 " + pos + "번 째에 있습니다.");
                    else System.out.println("찾는 데이터가 없습니다.");
                    break;
                case 6:
                    stack.clear();
                    break;
                case 0:
                    System.out.print("프로그램을 종료합니다.\n");
                    return;
            }
        }
    }

}
