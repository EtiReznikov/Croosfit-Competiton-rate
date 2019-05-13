package linkedlists;

/**
 * Sort linked list of Wieght event with other eventrate tiebreaker
 * @author EtiReznikov
 */
import java.util.LinkedList;

import nodes.Node;
import nodes.NodeAmrap_time;
import nodes.NodeWieght_event;
import competitors.Amrap;
import competitors.Weight;

public class Weight_eventLL extends SortLinkedList{

	public boolean add(NodeWieght_event competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		NodeWieght_event current=(NodeWieght_event) this.getTail();
		while (current!=null) {
			if (((Weight)competitor.getCompetitor()).getWieght()>((Weight)current.getCompetitor()).getWieght())
				current=(NodeWieght_event) current.getPrev();
			else if (((Weight)competitor.getCompetitor()).getWieght()<((Weight)current.getCompetitor()).getWieght()) {
				return add(competitor, current);
			}
			else {
				if (competitor.getEvent_rate()<current.getEvent_rate())
					current=(NodeWieght_event) current.getPrev();
				else {
					return add(competitor, current);
				}
			}
		}
		super.addFirst(competitor);
		return true;
	}



}
