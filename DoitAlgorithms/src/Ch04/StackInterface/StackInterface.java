/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.StackInterface;

/**
 *
 * @author Donghyeon <20183188>
 */
public interface StackInterface {

    public int push(int data);

    public int pop();

    public int peek();

    public int indexOf(int data);

    public void clear();

    public int capacity();

    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public void dump();
}
