package nodes;
/**
 * Node that representing a competitor in list, at AMRAP event with time tiebreaker
 *  @author EtiReznikov
 */
import java.util.Date;

import competitors.Competitor;
import competitors.Fortime;

public class NodeAmrap_time extends Node {
private long time;
	public NodeAmrap_time(Competitor competitor, String datetime) {
		super(competitor);
		this.time= Fortime.tomilisecond(datetime);
	}
	public NodeAmrap_time(NodeAmrap_time other) {
		super(other.getCompetitor());
		this.time=other.time;
	}
	public long getTime() {
		return time;
	}
	
	

}
