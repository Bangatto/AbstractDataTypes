import java.util.Arrays;

//enqueue add elements to the last position of the queue 
//dequeue remove and return the element at the first position of the queue that was inserted first
//Allow access to FIFO(First in,first out).
public class Queue {
	//private fields
	int head;
	int tail;
	int size;
	int Queue[] = new int[5];
	//write a method to enqueue elements at the last array
	public void enqueue(int data) {
		int length = Queue.length;
		if(size==length) {
			System.out.println("The Queue if Full");
		}else {
			Queue[tail] = data;
			tail = (tail +1)%length; //use a circular array and move the pointer to the next element
			size++;
		}
	}
	//write  a method to remove an element from the the first position in the Queue
	public void dequeue() {
		int length = Queue.length;
		if(size==0) {
			System.out.println("The Queue is Empty");
		}else {
			int data = Queue[head]; //copy the element at the head to be removed
			head = (head+1)%length; //move the pointer to the next element
			size--;
		}
		System.out.println(size);
	}
	// a method to extend the size of the array when it is Full
	public void extendSize() {
		//check whether the size equals the length
		int length = Queue.length;
		if(size==length) {
			//create a temp variable with expanded length twice the previous length
			int temp[]= new int[2*length];
			for(int i=0; i<length-1; i++) {
				temp[i]=Queue[(head+1)%length]; //copy from the element at the head on the prev Queue
			}
			head = 0;
			Queue=temp;
		}
		size ++;
	}
	//a function to display the elements
	public void show() {
		System.out.println("ELements:");
		for(int element: Queue) {
			System.out.print(element + " ");
		}
	}

	public static void main(String[] args) {
		Queue queue=new Queue();
		queue.enqueue(10);
		queue.enqueue(8);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(89);
		queue.show();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		
	}

}
