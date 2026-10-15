// Stack.java
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack2<T> {
    private final List<T> items = new ArrayList<>();

    // Add to the top
    public void push(T item) {
        items.add(item);
    }

    // Remove and return the top element
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }

    // Return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();   // bottom ... top
    }
}

// StackDemo.java
class StackDemo {
    public static void main(String[] args) {
        // Stack of Integers
        Stack2<Integer> ints = new Stack2<>();
        ints.push(10);
        ints.push(20);
        ints.push(30);

        System.out.println("Integer stack: " + ints);
        System.out.println("Peek: " + ints.peek());
        System.out.println("Pop: " + ints.pop());
        System.out.println("Pop: " + ints.pop());
        System.out.println("Size: " + ints.size());
        System.out.println("Is empty? " + ints.isEmpty());
        System.out.println("Pop: " + ints.pop());
        System.out.println("Is empty? " + ints.isEmpty());

        try {
            ints.pop();
        } catch (java.util.EmptyStackException e) {
            System.out.println("Cannot pop: stack is empty");
        }

        // The same class works for Strings: reverse a word
        Stack2<Character> letters = new Stack2<>();
        for (char c : "Hello".toCharArray()) {
            letters.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!letters.isEmpty()) {
            reversed.append(letters.pop());
        }
        System.out.println("Reversing \"Hello\": " + reversed);

        // ints.push("text");   // COMPILE ERROR: String is not an Integer
    }
}
