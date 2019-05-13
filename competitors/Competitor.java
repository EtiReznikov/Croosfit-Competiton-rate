package competitors;
/**
 * class that representing Competitor 
 * @author EtiReznikov
 */
public class Competitor {
	private int id, eventrate, totalrate, rownum;
	private String name;

	public Competitor(Competitor competitor) {
		this.id=competitor.id;
		this.eventrate=competitor.eventrate;
		this.totalrate=competitor.totalrate;
		this.rownum=competitor.rownum;
	}
	
	public Competitor(int id, int totalrate, int rownum) {
		this.id=id;
		this.totalrate=totalrate;
		this.rownum=rownum;
	}

	public Competitor clone() {
		return new Competitor(this);
	}
	public int getEventrate() {
		return eventrate;
	}
	public void setEventrate(int eventrate) {
		this.eventrate = eventrate;
	}
	public int getTotalrate() {
		return totalrate;
	}
	public void setTotalrate(int totalrate) {
		this.totalrate = totalrate;
	}
	public int getId() {
		return id;
	}

	public int getRownum() {
		return rownum;
	}

	
	
	




}
