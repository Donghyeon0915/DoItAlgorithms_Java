/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.DoubleStack;

import Ch04.StackInterface.StackInterface;

/**
 *
 * @author Donghyeon <20183188>
 */
public class DoubleStack {

    protected int max;
    protected int ptrA;
    protected int ptrB;
    protected int[] stk;
    private StackA stackA;
    private StackB stackB;

    public StackA getStackA() {
        return stackA;
    }

    public StackB getStackB() {
        return stackB;
    }
    
    public DoubleStack(int capacity) {
        this.max = capacity;
        this.ptrA = 0;
        this.ptrB = max - 1;
        
        try{
            stk = new int[max];
            stackA = new StackA();
            stackB = new StackB();
        }catch(OutOfMemoryError e){
            this.max = 0;
        }
    }
    
    public class EmptyStackException extends RuntimeException{

        public EmptyStackException() {
        }
        
    }
    
    public class OverflowStackException extends RuntimeException{

        public OverflowStackException() {
        }
        
    }
    
    
    class StackA implements StackInterface{
        @Override
        public int push(int data) throws OverflowStackException {
            if(ptrA >= max || ptrA > ptrB) throw new OverflowStackException();
            
            return stk[ptrA++] = data;
        }

        @Override
        public int pop() throws EmptyStackException {
            if(ptrA <= 0) throw new EmptyStackException();
            return stk[ptrA-- -1];
        }

        @Override
        public int peek() throws EmptyStackException {
            if(ptrA <= 0) throw new EmptyStackException();
            return stk[ptrA - 1];
        }

        @Override
        public int indexOf(int data) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            ptrA = 0;
        }

        @Override
        public int capacity() {
            return max - ptrB;
        }

        @Override
        public int size() {
            return ptrA;
        }

        @Override
        public boolean isEmpty() {
            return ptrA <= 0;
        }

        @Override
        public boolean isFull() {
            return (ptrA >= max) || (ptrA >= ptrB);
        }

        @Override
        public void dump() {
            for (int i = 0; i < ptrA; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println("");
        }
        
    }
    
    class StackB implements StackInterface{
        @Override
        public int push(int data) throws OverflowStackException {
            if((ptrB < ptrA) || (ptrB <= 0)) throw new OverflowStackException();
            return stk[ptrB--] = data;
        }

        @Override
        public int pop() throws EmptyStackException {
            if(ptrB >= max - 1) throw new EmptyStackException();
            return stk[ptrB++ +1];
        }

        @Override
        public int peek() throws EmptyStackException {
            if(ptrB >= max - 1) throw new EmptyStackException();
            return stk[ptrB + 1];
        }

        @Override
        public int indexOf(int data) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            ptrB = max - 1;
        }

        @Override
        public int capacity() {
            return max - ptrA;
        }

        @Override
        public int size() {
            return max - ptrB - 1;
        }

        @Override
        public boolean isEmpty() {
            return ptrB >= max - 1;
        }

        @Override
        public boolean isFull() {
            return ptrB <= 0 || ptrB <= ptrA;
        }

        @Override
        public void dump() {
            for (int i = max - 1; i > ptrB; i--) {
                System.out.print(stk[i] + " ");
            }
            System.out.println("");
        }
        
        
    }
}
