package linkedlists;
/**
 * Sort linked list of scores
 * @author EtiReznikov
 */
import java.util.LinkedList;
import java.util.List;

import nodes.Node;
import competitors.Competitor;

public abstract class SortLinkedList<E>  {
	private Node head;
	private Node tail;
	private int size;

	public SortLinkedList() {
		size = 0;
	}

	public int size() { return size; }

	public boolean isEmpty() { return size == 0; }

	public void addFirst(Node n) {
		n.setNext(head);
		if(head != null ) {head.setPrev(n);}
		head = n;
		if(tail == null) { tail = n;}
		size++;
	}

	public void addLast(Node n) {

		n.setPrev(tail);
		if(tail != null) {tail.setNext(n);}
		tail = n;
		if(head == null) { head = n;}
		size++;
	}
	
	

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	
	public boolean add (Node n, Node prev) {
		Node next=prev.getNext();
		
		if (next!=null) {
		if (next.getCompetitor().getId()== head.getCompetitor().getId()) {
			addFirst(n);
			return true;
		}
		}
		if (prev!=null) {
		if (prev.getCompetitor().getId()==tail.getCompetitor().getId()) {
			addLast(n);
			return true;
		}
		}
		size++;
		n.setNext(next);
		next.setPrev(n);
		n.setPrev(prev);
		prev.setNext(n);
		return true;	
	}
	
	public void removehead() {
		head=head.getNext();
		size--;
	}
   public void printList() {
	   Node current=head;
	   while (current!=null) {
		   System.out.println("id: "+current.getCompetitor().getId());
		   current=current.getNext();
	   }
   }


}
