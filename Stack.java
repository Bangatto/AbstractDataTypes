import java.util.Arrays;

//stack is a list but does not have a direct way to access the i-th element in the list
//push add elements to the top of the stack 
//pop remove and return the element at the top and that was pushed last
//Allow access to LIFO(last in first out).

public class Stack {
	//fields of the class..
	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	//constructor
	Stack(int size){
		stackSize = size;
		stackArray = new String[10];
	}
	//method to push in the array items
	public void push(String input) {
		//check if there`s enough space to add more elements
		if(topOfStack + 1 < stackSize) {
			topOfStack ++;
			stackArray[topOfStack] = input;
		}else {
			System.out.println("The stack is full");
		}
	}
	//a method to pop out the elements at the top
	public String pop(){
		//check if there are elements in the stack
		if(topOfStack >= 0) {
			System.out.println("Pop " + stackArray[topOfStack]);
			stackArray[topOfStack] = "-1";
			
			return stackArray[topOfStack --];
		}else {
			System.out.println("Sorry the stack is empty");
			
			return "-1";
		}
	}
	//a method to print elements at the top
	public String peek() {
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack");
		return stackArray[topOfStack];
	}
	//add multiple values
	public void pushMany(String multiValues) {
		String[] temp = multiValues.split(" ");
		for (int i=0; i <temp.length; i++) {
			push(temp[i]);
		}
	}
	//pop all the elements
	public void popAll() {
		for(int i = topOfStack; i >= 0; i-- ) {
			pop();
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		//add elements into the stack
		stack.push("10");
		stack.push("15");
		stack.push("30");
		stack.push("16");
		stack.push("89");
		stack.pushMany("8 9 18");
		//display the item at the top
		stack.peek();
		
		//remove elements with LIFO
		stack.pop();
		stack.pop();
		
		//pop all the items at once
		//stack.popAll();
	}

}
