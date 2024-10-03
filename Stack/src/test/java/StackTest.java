import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        // Initialize a new stack with a capacity of 5 before each test
        stack = new Stack(5);
    }

    /**
     * Testing push and pop
     */
    @Test
    void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Pop elements and check if they are in LIFO order
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    /**
     * Testing peek function without removing
     */
    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);
        
        // Peek the top element without removing it
        assertEquals(20, stack.peek());
        assertEquals(20, stack.peek()); // Peek again to check if it's not removed
    }

    /**
     * Test if stack is empty
     */
    @Test
    void testIsEmpty() {
        // A new stack should be empty
        assertTrue(stack.isEmpty());

        // After pushing an element, it should not be empty
        stack.push(5);
        assertFalse(stack.isEmpty());
    }

    /**
     * Test if stack is full
     */
    @Test
    void testIsFull() {
        // Fill the stack
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        // Stack should be full now
        assertTrue(stack.isFull());
    }

    /**
     * Test overloading of stack
     */
    @Test
    void testPushToFullStack() {
        // Fill the stack
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        // Expect an exception when pushing to a full stack
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.push(6); // Attempt to push when stack is full
        });
        assertEquals("Stack is full", exception.getMessage());
    }

    /**
     * Test exception on pop if stack is empty
     */
    @Test
    void testPopFromEmptyStack() {
        // Expect an exception when popping from an empty stack
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }

    /**
     * Test exception on peek if stack is empty
     */
    @Test
    void testPeekFromEmptyStack() {
        // Expect an exception when peeking from an empty stack
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }

    /**
     * Test if empty after push and pop
     */
    @Test
    void testPushPopWithCapacityOne() {
        // Stack with capacity 1
        Stack smallStack = new Stack(1);
        smallStack.push(100);
        
        // Check behavior with single capacity stack
        assertEquals(100, smallStack.pop());
        assertTrue(smallStack.isEmpty());
    }
}
