import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    public static final int CAPACITY = 1000; 
    private E[] data;                          
    private int f = 0;                         
    private int sz = 0;                        

    public ArrayQueue() {
        this(CAPACITY); 
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity]; 
    }

    public int size() {
        return sz; 
    }

    public boolean isEmpty() {
        return (sz == 0); 
    }

    public void enqueue(E e) {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length; 
        data[avail] = e;                     
    }

    public E first() {
        if (isEmpty()) {
            return null; 
        }
        return data[f]; 
    }

    public E dequeue() {
        if (isEmpty()) {
            return null; 
        }
        E answer = data[f];
        data[f] = null; 
        f = (f + 1) % data.length;
        sz--;
        return answer; 
    }

    public void rotate() {
        if (isEmpty()) {
            return; 
        }
       
        E frontElement = data[f];
      
        f = (f + 1) % data.length;
        enqueue(frontElement);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> Q = new ArrayQueue<>(5); 
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);

        System.out.println("Queue before rotation: " + Arrays.toString(Q.data)); 


        System.out.println("Queue after rotation: " + Arrays.toString(Q.data)); 
    }
}