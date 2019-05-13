package linkedlists;
/**
 * Sort linked list of time event with time tiebreaker
 * @author EtiReznikov
 */
import competitors.Fortime;
import nodes.Node;
import nodes.NodeFortime_time;

public class ForTimeForTimeLL extends SortLinkedList{
	public boolean add(NodeFortime_time competitor) {
		if (this.isEmpty()) {
			addFirst(competitor);
			return true;
		}
		NodeFortime_time current=(NodeFortime_time)this.getTail();
		while (current!=null) {
			if (((Fortime)competitor.getCompetitor()).getTime()<((Fortime)current.getCompetitor()).getTime())
				current=(NodeFortime_time)current.getPrev();
			else if (((Fortime)competitor.getCompetitor()).getTime()>((Fortime)current.getCompetitor()).getTime()) {

				return add(competitor, current);
			}
			else {
				if (((Fortime)competitor.getCompetitor()).getReps()==((Fortime)current.getCompetitor()).getReps()) {
		
					if(competitor.getSecond_time()<current.getSecond_time()) {
						System.out.println("yes");
						current=(NodeFortime_time)current.getPrev();
					}
					else
						return add(competitor, current);
				}
				else if (((Fortime)competitor.getCompetitor()).getReps()>((Fortime)current.getCompetitor()).getReps())
					current=(NodeFortime_time)current.getPrev();
	
				else if(((Fortime)competitor.getCompetitor()).getReps()<((Fortime)current.getCompetitor()).getReps())
					
				
					return add(competitor, current);
				
			}
		}
		addFirst(competitor);
		return true;
	}
}
