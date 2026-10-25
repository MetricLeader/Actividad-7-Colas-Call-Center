package cola;
public interface ICola<T> {
    public void enqueue(T dato);
    public T dequeue();
    public T peek();
    public boolean empty();
    public int size();
    public void enqueuePrioritario(T dato);
}
