/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch05.Recursion;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Pillar{
    int n;
    int x;
    int y;

    public Pillar(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class TowerOfHanoi {

    /**
     * @param args the command line arguments
     */
    public static int saveN;
    public static void move(int n, int x, int y){
        if(n > 1) move(n - 1, x, 6-x-y);
        System.out.printf("원반[%d]를 %d에서 %d로 옮김\n", n, x,y);
        if(n > 1) move(n - 1, 6-x-y, y);
    }
    
    public static void moveForLoop(int n, int x, int y){
        Stack<Pillar> stack = new Stack<>();
        StringJoiner answer = new StringJoiner("\n");
        
        long moveCnt = 0;
        
        while(true){
            
            if(n > 0){
                stack.push(new Pillar(n,x,y));
                n = n - 1;
                y = 6 - x - y;
                continue;
            }
            if(!stack.isEmpty()){
                moveCnt++;
                Pillar nowP = stack.pop();
                n = nowP.getN();
                x = nowP.getX();
                y = nowP.getY();
                
                if(saveN < 20) answer.add(x + " " + y);
                
                n = n - 1;
                x = 6 - x - y;
                continue;
            }
            
            break;
        }
        
        System.out.println(moveCnt);
        if(saveN < 20) System.out.println(answer);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        saveN = scan.nextInt();
        moveForLoop(saveN, 1, 3);
    }
    
}
