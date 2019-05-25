/**
 * Author: Tyson Pham
 * Class: COMP 352 Data Structure and Algorithm
 */
package Default;

/**
 * Author:Tyson Pham
 *
 * @param <T>
 */
public interface iStack<T> {
    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty
     *
     * @returns true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack
     *
     * @param t, the element to be inserted
     */
    void push(T t);

    /**
     * Returns, but does not remove, the element at the top of the stack
     *
     * @return top element of the stack (null if empty)
     */
    T top();

    /**
     * Removes and returns the top element from the stack
     *
     * @return element removed (or null if empty)
     */
    T pop();

    /**
     *Prints out whats in the stack
     * @return a string
     */
    void show();

}
