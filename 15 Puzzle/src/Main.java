import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

public class Main {
	protected Node dummy;
	protected Node tail;
	static class Node{
		int data;
		Node next;
		
		Node(int i, Node n){
			data = i;
			next = n;
		}
	}
	
	Main(){
		Start();
	}
	public void Start() {
		ArrayList<Integer> numbers = new ArrayList<>();
        
        // Adding numbers from 1 to 15 to the list
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        // Shuffling the list
        Collections.shuffle(numbers);
		dummy = new Node(0,null);
		Node p = dummy;
	    for (int i = 0; i < numbers.size(); i++) {
	        Integer number = numbers.get(i);
	        p.next = new Node(number, null);
	        p = p.next;
	    }
	    tail = new Node(0,null);
	    p.next = tail;
	}
	
	public int getData(int index) {
        Node current = dummy.next;
        for (int i = 0; i < index; i++) {
            if (current == null) return -1; // Index out of bounds
            current = current.next;
        }
        return current.data;
    }
	
	public Node findNode(int data) {
		Node current = dummy.next;
	    while (current != null) {
	        if (current.data == data) return current;
	        current = current.next;
	    }
	    return null;
    }
	
	public int findIndex(int data) {
		Node current = dummy.next;
		int count = 0;
	    while (current != null) {
	        if (current.data == data) return count;
	        current = current.next;
	        count++;
	    }
	    return count;
    }
	
	public void printList() {
		for(int i = 0; i<16;i++) {
			System.out.println(getData(i));
		}
	}
	
	public void cheatList() {
		Node p = dummy;
		dummy.next = null;
	    for (int i = 1; i < 16; i++) {
	        p.next = new Node(i, null);
	        p = p.next;
	    }
	    tail = new Node(0,null);
	    p.next = tail;
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(() -> {
            new Play().setVisible(true);
        });
	}
	
}
