public class GenStack<T> implements iStack<T> {

private static int capacity=2;
private T[] data;
private int top = 0;
    public GenStack() {
    data = (T[]) new Object();
    }

    @Override
    public int size() {
        return (top);
    }

    @Override
    public boolean isEmpty() {
        return (size()==0);
    }

    @Override
    public void push(T t) {
    if(size())
    }

    @Override
    public T top() {
        return null;
    }

    @Override
    public T pop() {
        return null;
    }
}
