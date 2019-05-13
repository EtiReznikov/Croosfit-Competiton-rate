package linkedlists;
/**
 * Sort linked list of AMRAP event with time tiebreaker
 * @author EtiReznikov
 */
import java.util.LinkedList;

import nodes.Node;
import nodes.NodeAmrap_time;
import competitors.Amrap;

public class Amrap_timeLL extends  SortLinkedList{
	

	public boolean add(NodeAmrap_time competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		NodeAmrap_time current=(NodeAmrap_time) this.getTail();
		while (current!=null) {
			if (((Amrap)competitor.getCompetitor()).getNumofreps()>((Amrap)current.getCompetitor()).getNumofreps())
				current=(NodeAmrap_time) current.getPrev();
			else if (((Amrap)competitor.getCompetitor()).getNumofreps()<((Amrap)current.getCompetitor()).getNumofreps()) {
				return add(competitor, current);
			}
			else {
				if (competitor.getTime()<current.getTime())
					current=(NodeAmrap_time) current.getPrev();
				else {
					return add(competitor, current);
				}
			}
		}
		addFirst(competitor);
		return true;

	}
}
