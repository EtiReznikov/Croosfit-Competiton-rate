package linkedlists;
/**
 * Sort linked list of Wieght event
 * @author EtiReznikov
 */
import java.util.LinkedList;

import nodes.Node;
import nodes.NodeWieght_event;
import competitors.Competitor;
import competitors.Weight;

public class WeightLL extends SortLinkedList {
	

	public boolean add(Node competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		Node current= this.getTail();
		while (current!=null) {
			if (((Weight)competitor.getCompetitor()).getWieght()>((Weight)current.getCompetitor()).getWieght())
				current=current.getPrev();
			else if (((Weight)competitor.getCompetitor()).getWieght()<=((Weight)current.getCompetitor()).getWieght()) {
				return add(competitor, current);
			}
		}
		addFirst(competitor);
		return true;
	
	}

	
}
