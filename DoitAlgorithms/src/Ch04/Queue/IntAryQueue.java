/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch04.Queue;

/**
 *
 * @author Donghyeon <20183188>
 */
public class IntAryQueue {

    private int max;    // 큐 용량
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체
    private int front;  // 인큐하는 데이터 가운데 첫 번째 요소의 인덱스를 저장(큐의 처음)
    private int rear;   // 인큐한 데이터 가운데 마지막 요소의 다음 인덱스를 저장(다음 인큐가 될 인덱스)

    public IntAryQueue(int capacity) {
        this.max = capacity;
        front = rear = num = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public class OverflowIntQueueException extends RuntimeException {

        public OverflowIntQueueException() {
        }

    }

    public class EmptyIntQueueException extends RuntimeException {

        public EmptyIntQueueException() {
        }

    }

    /*
    * 큐에 데이터를 인큐하는 메서드
    * 인큐에 성공하면 인큐한 값을 그대로 반환
    * 큐가 가득 차서 인큐할 수 없으면 OverflowIntQueueException을 던짐
     */
    public int enque(int data) throws OverflowIntQueueException {
        if (num >= max) {
            throw new OverflowIntQueueException();
        }
        num++;

        que[rear++] = data;
        if (rear >= max) {
            rear %= max;
        }

        return data;
    }

    /*
    * 큐에서 데이터를 디큐하고 그 값을 반환하는 메서드
    * 큐가 비어 있어 디큐할 수 없으면 EmptyIntQueueException을 던짐
     */
    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        num--;
        int dequeData = que[front++];
        if (front >= max) {
            front %= max;
        }

        return dequeData;
    }

    /*
    * 피크 메서드 peek
    * 맨 앞의 데이터(디큐에서 꺼낼 데이터)를 '몰래 엿보는' 메서드
    * 큐가 비어있으면 EmptyIntQueueException을 던짐
     */
    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    /*
    * 검색 메서드 indexOf
    * 큐의 배열에서 x와 같은 데이터가 저장되어 있는 위치를 알아내는 메서드
    * 프런트에서 리어 쪽으로 선형 검색
    * 스캔의 시작은 큐의 첫 요소
    * 검색에 성공하면 찾은 요소의 인덱스를 반환, 실패시 -1 반환
     */
    public int indexOf(int x) {
        for (int i = front; i != rear; i++) {
            if (que[i] == x) {
                return i;
            }
            if (i >= max) {
                i %= max;
            }
        }

        return -1;
    }

    /*
    * 모든 데이터를 삭제하는 메서드 clear
    * 현재 큐의 모든 데이터를 삭제하는 메서드
     */
    public void clear() {
        front = rear = num = 0;
    }

    /*
    * 최대 용량을 확인하는 메서드 capacity
    * 큐의 최대 용량을 반환하는 메서드
     */
    public int capacity() {
        return max;
    }

    /*
    * 데이터 수를 확인하는 메서드 size
    * 현재 큐의 데이터 수를 반환하는 메서드
     */
    public int size() {
        return num;
    }

    /*
    * 큐가 비어 있는지 판단하는 메서드 isEmpty
    * 큐가 비어 있으면 true, 그렇지 않으면 false
     */
    public boolean isEmpty() {
        return num <= 0;
    }

    /*
    * 큐가 가득 찼는지 판단하는 메서드 isFull
    * 큐가 가득 찼으면 true, 그렇지 않으면 false
     */
    public boolean isFull() {
        return num >= max;
    }

    /*
    * 모든 데이터를 출력하는 메서드 dump
     */
    public void dump() {
        //System.out.println("front = " + front + " rear = " + rear);
        if (num != 0 && front == rear) {
            for (int i : que) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = front; i != rear; i++) {
                // System.out.print("i = " + i + " : ");
                System.out.println(que[i] + " ");
                if (i >= max) {
                    i %= max;
                }
            }
        }
        System.out.println("");
    }
}
