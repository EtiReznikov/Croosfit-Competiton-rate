package nodes;

import competitors.Competitor;

public class NodeAmrap_reps extends Node{
	private int secondreps;
	public NodeAmrap_reps(Competitor competitor, int reps) {
		super(competitor);
		this.secondreps=reps;
	}
	public NodeAmrap_reps(NodeAmrap_reps other) {
		super(other.getCompetitor());
		this.secondreps=other.secondreps;
	}
	public int getSecondreps() {
		return secondreps;
	}


}
