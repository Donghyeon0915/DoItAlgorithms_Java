/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.StackInterface;

/**
 * Stack Interface
 * @author Donghyeon <20183188>
 */
public interface StackInterfaceToGeneric<E> {
    public E push(E data);
    public E pop();
    public E peek();
    public int indexOf(E data);
    public void clear();
    public int capacity();
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public void dump();
}
