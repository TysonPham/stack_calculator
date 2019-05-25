public class GenStack<T> implements iStack<T> {

 private int capacity, top;
 private T[] data;


    public GenStack() {
        capacity = 2;
        top=-1;
        data = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (top+1);
    }

    @Override
    public boolean isEmpty() {
        return (top==-1);
    }

    @Override
    public void push(T t) {
    if(size() == data.length)
        expand();
    data[size()] = t;
    top++;

    }

    @Override
    public T top() {
        if(isEmpty())
            return null;
        return data[top];
    }

    @Override
    public T pop() {
        if(isEmpty())
            return null;
        T answer = data[top];
        data[top]=null;
        return answer;
    }

    public void expand() {
        T newStack[] = (T[]) new Object[capacity * 2];
        System.arraycopy(data, 0, newStack, 0, size());
        data = newStack;
        capacity *= 2;
    }

    public void shrink() {
        if (size() <= (capacity / 2) / 2) {
            capacity /= 2;
            @SuppressWarnings("unchecked")
            T newStack[] = (T[]) new Object[capacity];
            System.arraycopy(data, 0, newStack, 0, size());
            data = newStack;
        }
    }
    public void show() {
        System.out.print("Stack: ");
        for (T n : data) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
