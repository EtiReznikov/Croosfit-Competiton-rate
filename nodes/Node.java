package nodes;
/**
 * Node that representing a competitor in list
 *  @author EtiReznikov
 */
import competitors.Competitor;

public class Node {
	private Competitor competitor;
	private Node next, prev;
	
	public Node(Competitor competitor) {
		this.competitor=competitor;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Competitor getCompetitor() {
		return competitor;
	}
	
	public String toString() {
		return "id: "+this.getCompetitor().getId()+" event rate: "+ this.competitor.getEventrate()+" total rate: "+ this.competitor.getTotalrate();
	}
	

}
