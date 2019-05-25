/**
 * Author: Tyson Pham
 * Class: COMP 352 Data Structure and Algorithm
 */
package Default;


public class GenStack<E> implements iStack<E> {
    private int capacity, top;
    private E[] stack;

    /**
     * Default Constructor
     */
    @SuppressWarnings("unchecked")
    public GenStack() {
        capacity = 2;
        top = -1;
        stack = (E[]) new Object[capacity];
    }

    /**
     * Is Stack empty?
     *
     * @return size of stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Is stack empty?
     *
     * @return boolean response
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Is it full?
     *
     * @return boolean response
     */
    public boolean isFull() {
        return size() == capacity - 1;
    }

    /**
     * What is the top value of the stack? without removing it from the stack
     *
     * @return top value
     */
    public E top() {
        if (isEmpty())
            return null;
        return stack[top];
    }

    /**
     * Insert value at the top of the stack
     *
     * @param element
     *            value pushed inside the stack
     */
    public void push(E element) {
        if (isFull())
            expand();
        stack[size()] = element;
        top++;
    }

    /**
     * Return top value as well as removing it from the stack
     *
     * @return top value
     */
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
     * Dynamic Array, expand!
     */
    public void expand() {
        @SuppressWarnings("unchecked")
        E newStack[] = (E[]) new Object[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0, size());
        stack = newStack;
        capacity *= 2;
    }

    /**
     * Shrink array if to big!
     */
    public void shrink() {
        if (size() <= (capacity / 2) / 2) {
            capacity /= 2;
            @SuppressWarnings("unchecked")
            E newStack[] = (E[]) new Object[capacity];
            System.arraycopy(stack, 0, newStack, 0, size());
            stack = newStack;
        }
    }

    /**
     * Display everything inside current stack
     */
    public void show() {
        System.out.print("Stack: ");
        for (E n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}