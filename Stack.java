class Stack {
	private int array[];
	private int capacity;
	private int top;
	
	public Stack(int capacity) {
		this.array = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}
	
	public void push(int item) {
		if (isFull())
			throw new IndexOutOfBoundsException("Stack is full");
		array[++top] = item;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		return array[top--];
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		return array[top];
	}
	
	public Boolean isFull() {
		return (this.top+1 == this.capacity);
	}
	
	public Boolean isEmpty() {
		return (top < 0);
	}
}