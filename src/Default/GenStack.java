/**
 * Author: Tyson Pham
 * Class: COMP 352 Data Structure and Algorithm
 */
package Default;


public class GenStack<E> implements iStack<E> {
    private int capacity, top;
    private E[] stack;


    public GenStack() {
        capacity = 2;
        top = -1;
        stack = (E[]) new Object[capacity];
    }


    public int size() {
        return top + 1;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean isFull() {
        return size() == capacity - 1;
    }


    public E top() {
        if (isEmpty())
            return null;
        return stack[top];
    }


    public void push(E element) {
        if (isFull())
            expand();
        stack[size()] = element;
        top++;
    }


    public E pop() {
        if (isEmpty())
            return null;
        E value = stack[top];
        stack[size()] = null;
        top--;
        shrink();
        return value;
    }

    /**
     * Linear incremental for dynamic array
     * c=10
     */
    public void expand() {
        @SuppressWarnings("unchecked")
        E newStack[] = (E[]) new Object[capacity + 10];
        System.arraycopy(stack, 0, newStack, 0, size());
        stack = newStack;
        capacity += 10;
    }


    public void shrink() {
        if (size() <= (capacity / 2) / 2) {
            capacity /= 2;
            @SuppressWarnings("unchecked")
            E newStack[] = (E[]) new Object[capacity];
            System.arraycopy(stack, 0, newStack, 0, size());
            stack = newStack;
        }
    }


    public void show() {
        System.out.print("Stack: ");
        for (E n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}