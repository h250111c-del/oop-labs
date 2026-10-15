// LinkedList.java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    // Static nested class: a Node doesn't need access to any LinkedList object
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Add to the end
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Add to the front
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + ", size " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    // Required by Iterable<T>: this is what makes for-each work
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // Inner (non-static) class: needs access to this list's head
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;    // each iterator has its own position

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T item : this) {              // uses our own iterator
            if (sb.length() > 1) sb.append(", ");
            sb.append(item);
        }
        return sb.append("]").toString();
    }
}

// ListDemo.java
class ListDemo {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Mellisa");
        names.add("Merit");
        names.add("Tapiwa");
        names.addFirst("Faith");

        System.out.println("List: " + names);
        System.out.println("Size: " + names.size());
        System.out.println("get(2): " + names.get(2));

        System.out.println("\nFor-each loop:");
        for (String n : names) {
            System.out.println("  " + n);
        }

        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("\nSum of numbers: " + sum);

        // Each for-each creates its own iterator, so nested loops work
        LinkedList<Integer> pair = new LinkedList<>();
        pair.add(1);
        pair.add(2);
        System.out.println("\nNested loops:");
        for (int a : pair) {
            for (int b : pair) {
                System.out.println("  " + a + "-" + b);
            }
        }
    }
}
