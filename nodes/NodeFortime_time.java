package nodes;

import competitors.Competitor;
import competitors.Fortime;

public class NodeFortime_time extends Node {
private long second_time;
	public NodeFortime_time(Competitor competitor, String time) {
		super(competitor);
		this.second_time=Fortime.tomilisecond(time);
	}
	public long getSecond_time() {
		return second_time;
	}
	
	

}
