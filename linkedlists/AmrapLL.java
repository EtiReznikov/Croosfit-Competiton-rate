package linkedlists;
/**
 * Sort linked list of AMRAP event 
 * @author EtiReznikov
 */
import java.util.LinkedList;

import nodes.Node;
import nodes.NodeAmrap_time;
import competitors.Amrap;
import competitors.Competitor;

public class AmrapLL extends  SortLinkedList{

	public boolean add(Node competitor) {
		if (this.isEmpty()){
			addFirst(competitor);
			return true;
		}
		Node current=this.getTail();
		while (current!=null) {
			if (((Amrap)competitor.getCompetitor()).getNumofreps()>((Amrap)current.getCompetitor()).getNumofreps())
				current= current.getPrev();
			else if (((Amrap)competitor.getCompetitor()).getNumofreps()<=((Amrap)current.getCompetitor()).getNumofreps()) {
				return add(competitor, current);
			}
		}
		addFirst(competitor);
		return true;

	}
}
