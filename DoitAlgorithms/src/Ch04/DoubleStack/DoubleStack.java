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
public abstract class DoubleStack {

    private int max;
    private int ptr;
    private int[] stk;

    protected int getMax() {
        return max;
    }

    protected int getPtr() {
        return ptr;
    }

    protected int[] getStk() {
        return stk;
    }

    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public class OverflowStackException extends RuntimeException{
        public OverflowStackException() {}
    }
    
    public abstract int push(int data);
    public abstract int pop();
    public abstract int peek();
    public abstract int indexOf(int data);
    public abstract void clear();
    public abstract int capacity();
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract void dump();
}
