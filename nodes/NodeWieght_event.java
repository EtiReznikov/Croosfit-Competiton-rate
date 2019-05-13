package nodes;

/**
 * Node that representing a competitor in list, at wieght event with other event tiebreaker
 *  @author EtiReznikov
 */

import competitors.Competitor;

public class NodeWieght_event extends Node{
	private int event_rate;
	public NodeWieght_event(Competitor competitor, int rate) {
		super(competitor);
		event_rate=rate;
	}
	public NodeWieght_event(NodeWieght_event other) {
		super(other.getCompetitor());
		this.event_rate=other.event_rate;
	}
	public int getEvent_rate() {
		return event_rate;
	}


}
