/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.GenericStack;

import java.lang.reflect.Array;

/**
 *
 * @author Donghyeon <20183188>
 * @param <E>
 */

/*
* 임의의 객체형 데이터를 쌓을 수 있는 Generic Stack
 */
public class Gstack<E> {

    private int max;    // 스택 용량
    private int ptr;    // 스택 포인터
    private E[] stk;    // 스택 본체

    public Gstack(Class<E> clazz, int capacity) {
        this.max = capacity;
        this.ptr = 0;

        try {
            stk = (E[]) Array.newInstance(clazz, max);
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }
    
    /*
    * push : 스택에 데이터를 푸시하는 메서드.
    * 스택이 가득 차서 푸시할 수 없는 경우 예외 OverflowIntStackException을 던짐
     */
    public E push(E data) throws RuntimeException{
        if (ptr >= max) throw new RuntimeException();
        return stk[ptr++] = data;
    }

    /*
    * pop : 스택의 꼭대기에서 데이터를 팝하고 그 값을 반환하는 메서드
    * 스택이 비어 있어 팝을 할 수 없는 경우 예외 EmptyIntStackException을 던집니다.
     */
    public E pop() throws RuntimeException{
        if(ptr <= 0) throw new RuntimeException();
        return stk[ptr--];
    }

    /*
    * peek : 스택의 꼭대기에 있는 데이터를 "몰래 엿보는" 메서드
    * 스택이 비어 있는 경우 예외 EmptyIntStackException을 던집니다.
     */
    public E peek() throws RuntimeException {
        if(ptr <= 0) throw new RuntimeException();
        return stk[ptr - 1];
    }

    /*
    * indexOf : 스택 본체의 배열 stk에 x와 같은 값의 데이터가 포함되어 있는지,
    * 포함되어 있다면 배열의 어디에 들어 있는지를 조사하는 메서드.
    * 검색은 꼭대기(top)에서 바닥(bottom)으로 선형 검색 (검색 성공 시 인덱스 반환, 실패시 -1 반환)
     */
    public int indexOf(E data) {
        for (int i = ptr - 1; i >= 0; i--) {
            if(stk[i].equals(data)) return i + 1;
        }
        
        return -1;
    }

    /*
    * clear : 스택의 모든 요소를 삭제하는 메서드 
     */
    public void clear() {
        ptr = 0;
    }

    /*
    * capacity : 용량을 확인하는 메서드
     */
    public int capacity() {
        return max;
    }

    /*
    * size : 데이터 수를 확인하는 메서드
     */
    public int size() {
        return ptr;
    }

    /*
    * isEmpty : 스택이 비어 있는지 검사하는 메소드
    * 비어 있으면 true, 그렇지 않으면 false
     */
    public boolean isEmpty() {
        return ptr <= 0;
    }

    /*
    * isFull : 스택이 가득 찼는지 검사하는 메서드
    * 가득 찼으면 true, 그렇지 않으면 false
     */
    public boolean isFull() {
        return ptr >= max;
    }

    /*
    * dump : 스택 안에 있는 모든 데이터를 표시하는 메서드
    * 스택에 쌓여있는 모든 데이터를 바닥에서 꼭대기 순으로 표시하는 메서드
    * 스택이 비어있으면 "스택이 비어있습니다."라고 출력
     */
    public void dump() {
        if(ptr <= 0){
            System.out.print("스택이 비어있습니다.");
            return;
        }
        for (int i = 0; i < ptr; i++) {
            System.out.print(stk[i] + " ");
        }
        System.out.println("");
    }
}
