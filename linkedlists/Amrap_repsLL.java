package linkedlists;

import java.util.LinkedList;
/**
 * Sort linked list of AMRAP event with AMRAP tiebreaker
 * @author EtiReznikov
 */

import nodes.Node;
import nodes.NodeAmrap_reps;
import competitors.Amrap;
import competitors.Competitor;

public class Amrap_repsLL extends  SortLinkedList {


	public boolean add(NodeAmrap_reps competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		NodeAmrap_reps current=(NodeAmrap_reps) this.getTail();
		while (current!=null) {
			if (((Amrap)competitor.getCompetitor()).getNumofreps()>((Amrap)current.getCompetitor()).getNumofreps())
				current=(NodeAmrap_reps) current.getPrev();
			else if (((Amrap)competitor.getCompetitor()).getNumofreps()<((Amrap)current.getCompetitor()).getNumofreps()) {
				return add(competitor, current);
			}
			else {
				if (competitor.getSecondreps()>current.getSecondreps())
					current=(NodeAmrap_reps) current.getPrev();
				else {
					return add(competitor, current);
				}
			}
		}
		addFirst(competitor);
		return true;
	}
}
