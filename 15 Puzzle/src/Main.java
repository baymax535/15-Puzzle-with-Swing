import java.util.ArrayList;
import java.util.Collections;

public class Main {
	protected Node dummy;
	
	static class Node{
		int data;
		Node next;
		
		Node(int i, Node n){
			data = i;
			next = n;
		}
	}
	
	Main(){
		ArrayList<Integer> numbers = new ArrayList<>();
        
        // Adding numbers from 1 to 15 to the list
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        // Shuffling the list
        Collections.shuffle(numbers);
		dummy = new Node(0,null);
		int i =1;
		for(Node p = dummy; p!=null && i<16; p = p.next, i++) {
			Node newNode = new Node(numbers.get(i), null);
			dummy.next = newNode;
		}
	}
	public void Start() {
		new Main();
	}
	public void printList() {
		for(Node p = dummy; p!=null;p=p.next) {
			System.out.println(p.data);
		}
	}
	
}
