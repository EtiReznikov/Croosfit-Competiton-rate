package linkedlists;
/**
 * Sort linked list of time event 
 * @author EtiReznikov
 */
import java.util.LinkedList;

import nodes.Node;
import competitors.Competitor;
import competitors.Fortime;

public class ForTimeLL  extends  SortLinkedList{


	public boolean add(Node competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		Node current=this.getTail();
		while (current!=null) {
			if (((Fortime)competitor.getCompetitor()).getTime()<((Fortime)current.getCompetitor()).getTime())
				current=current.getPrev();
			else if (((Fortime)competitor.getCompetitor()).getTime()>((Fortime)current.getCompetitor()).getTime()) {
				
				
				return add(competitor, current);
			}
			else {
				if (((Fortime)competitor.getCompetitor()).getReps()>((Fortime)current.getCompetitor()).getReps())
					current=current.getPrev();
				else {
					return add(competitor, current);
				}
			}
		}
		addFirst(competitor);
		return true;
	}



	

}

