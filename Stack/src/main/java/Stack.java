
/**
 * A simple implementation of a stack data structure using an integer array.
 * This stack has a fixed capacity and supports typical stack operations such as push, pop, and peek.
 */
class Stack {

    /** The array used to store elements in the stack. */
    private int array[];
    /** The maximum capacity of the stack. */
    private int capacity;
    /** The index of the top element in the stack. */
    private int top;

    /**
     * Constructs a new stack with the specified capacity.
     * 
     * @param capacity the maximum number of elements the stack can hold
     */
    public Stack(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    /**
     * Pushes an item onto the top of the stack.
     * 
     * @param item the item to push onto the stack
     * @throws IndexOutOfBoundsException if the stack is full
     */
    public void push(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Stack is full");
        }
        array[++top] = item;
    }

    /**
     * Removes and returns the item from the top of the stack.
     * 
     * @return the item removed from the top of the stack
     * @throws IndexOutOfBoundsException if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return array[top--];
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * 
     * @return the item at the top of the stack
     * @throws IndexOutOfBoundsException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return array[top];
    }

    /**
     * Checks if the stack is full.
     * 
     * @return {@code true} if the stack is full, otherwise {@code false}
     */
    public Boolean isFull() {
        return (this.top + 1 == this.capacity);
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return {@code true} if the stack is empty, otherwise {@code false}
     */
    public Boolean isEmpty() {
        return (top < 0);
    }
}
