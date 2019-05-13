package rate;
/**
 * A class of methods for scoring by event type
 *  @author EtiReznikov
 */

import java.io.IOException;

import competitors.Amrap;
import competitors.Competitor;
import competitors.Fortime;
import competitors.Weight;
import linkedlists.ForTimeForTimeLL;
import linkedlists.ForTimeLL;
import linkedlists.SortLinkedList;
import nodes.NodeAmrap_reps;
import nodes.NodeFortime_time;

public class Rate {
	/**
	 * 
	 * @param competitors- List of competitors of AMRAP event
	 * @return Competitor[]- array of competitros with score of this event
	 * @throws IOException
	 */
	public static Competitor[]  AmrapRate(SortLinkedList competitors) throws IOException{
		Competitor competitorsrate[] = new Competitor[competitors.size()];
		int ratedcompetitors=1;
		int point=1;
		int index=0;
		int lastscore= ((Amrap)(competitors.getHead().getCompetitor())).getNumofreps();
		competitors.getHead().getCompetitor().setEventrate(point);
		competitors.getHead().getCompetitor().setTotalrate(point+competitors.getHead().getCompetitor().getTotalrate());
		competitorsrate[index++]=competitors.getHead().getCompetitor();
		competitors.removehead();
		while (!competitors.isEmpty()) {
			ratedcompetitors++;
			if (lastscore>((Amrap)(competitors.getHead().getCompetitor())).getNumofreps()) {
				lastscore= ((Amrap)(competitors.getHead().getCompetitor())).getNumofreps();
				competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
				point=ratedcompetitors;
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
			else {
				competitors.getHead().getCompetitor().setEventrate(point);
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
		}
		return competitorsrate;
	}
	/**
	 * 
	 * @param competitors- List of competitors of fortime event
	 * @return Competitor[]- array of competitros with score of this event
	 * @throws IOException
	 */
	public static Competitor[] FortimeRate(ForTimeLL competitors) throws IOException {
		Competitor competitorsrate[] = new Competitor[competitors.size()];
		int ratedcompetitors=1;
		int point=1;
		int index=0;
		long lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
		int lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
		competitors.getHead().getCompetitor().setEventrate(point);
		competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
		competitorsrate[index++]=competitors.getHead().getCompetitor();
		competitors.removehead();
		while (!competitors.isEmpty()) {
			ratedcompetitors++;
			if (lasttime<((Fortime)(competitors.getHead().getCompetitor())).getTime()) {
				lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
				lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
				competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
				point++;
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
			else {
				if (lastreps==((Fortime)(competitors.getHead().getCompetitor())).getReps()) {
					competitors.getHead().getCompetitor().setEventrate(point);
					competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
					competitorsrate[index++]=competitors.getHead().getCompetitor();
					competitors.removehead();
				}
				else {
					lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
					lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
					competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
					point=ratedcompetitors;
					competitors.getHead().getCompetitor().setTotalrate(point+competitors.getHead().getCompetitor().getTotalrate());
					competitorsrate[index++]=competitors.getHead().getCompetitor();
					competitors.removehead();
				}
			}
		}
		return competitorsrate;
	}
	/**
	 * 
	 * @param competitors- List of competitors of wieght event
	 * @return Competitor[]- array of competitros with score of this event
	 * @throws IOException
	 */
	public static Competitor[] WieghtRate(SortLinkedList competitors) throws IOException {
		Competitor competitorsrate[] = new Competitor[competitors.size()];
		int ratedcompetitors=1;
		int point=1;
		int index=0;
		double lastscore= ((Weight)(competitors.getHead().getCompetitor())).getWieght();
		competitors.getHead().getCompetitor().setEventrate(point);
		competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
		competitorsrate[index++]=competitors.getHead().getCompetitor();
		competitors.removehead();
		while (!competitors.isEmpty()) {
			ratedcompetitors++;
			if (lastscore>((Weight)(competitors.getHead().getCompetitor())).getWieght()) {
				lastscore= ((Weight)(competitors.getHead().getCompetitor())).getWieght();
				competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
				point=ratedcompetitors;
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
			else {
				competitors.getHead().getCompetitor().setEventrate(point);
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
		}
		return competitorsrate;
	}
	/**
	 * 
	 * @param competitors- List of competitors of for time event with for time tiebreaker
	 * @return Competitor[]- array of competitros with score of this event
	 * @throws IOException
	 */
	public static Competitor[] FortimeFortimeRate(ForTimeForTimeLL competitors) throws IOException {
		Competitor competitorsrate[] = new Competitor[competitors.size()];
		int ratedcompetitors=1;
		int point=1;
		int index=0;
		long lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
		int lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
		long lasttiebreaker=((NodeFortime_time) (competitors.getHead())).getSecond_time();
		competitors.getHead().getCompetitor().setEventrate(point);
		competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
		competitorsrate[index++]=competitors.getHead().getCompetitor();
		competitors.removehead();
		while (!competitors.isEmpty()) {
			ratedcompetitors++;
			if (lasttime<((Fortime)(competitors.getHead().getCompetitor())).getTime()) {
				lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
				lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
				lasttiebreaker=((NodeFortime_time) (competitors.getHead())).getSecond_time();
				competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
				point++;
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
			else {
				if (lastreps==((Fortime)(competitors.getHead().getCompetitor())).getReps()) {
					if (lasttiebreaker< ((NodeFortime_time) (competitors.getHead())).getSecond_time()) {
						lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
						lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
						lasttiebreaker=((NodeFortime_time) (competitors.getHead())).getSecond_time();
						competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
						point++;
						competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
						competitorsrate[index++]=competitors.getHead().getCompetitor();
						competitors.removehead();
					}
					else {
						competitors.getHead().getCompetitor().setEventrate(point);
						competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
						competitorsrate[index++]=competitors.getHead().getCompetitor();
						competitors.removehead();
					}
				}
				else {
					lasttime= ((Fortime)(competitors.getHead().getCompetitor())).getTime();
					lastreps= ((Fortime)(competitors.getHead().getCompetitor())).getReps();
					lasttiebreaker=((NodeFortime_time) (competitors.getHead())).getSecond_time();
					competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
					point=ratedcompetitors;
					competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
					competitorsrate[index++]=competitors.getHead().getCompetitor();
					competitors.removehead();
				}
			}
		}
		return competitorsrate;
	}
	/**
	 * 
	 * @param competitors- List of competitors of AMRAP event with AMRAP tiebreaker
	 * @return Competitor[]- array of competitros with score of this event
	 * @throws IOException
	 */
	public static Competitor[]  AmrapRepsRate(SortLinkedList competitors) throws IOException{
		Competitor competitorsrate[] = new Competitor[competitors.size()];
		int ratedcompetitors=1;
		int point=1;
		int index=0;
		int lastscore= ((Amrap)(competitors.getHead().getCompetitor())).getNumofreps();
		int lastscoretiebreaker= ((NodeAmrap_reps) (competitors.getHead())).getSecondreps();
		competitors.getHead().getCompetitor().setEventrate(point);
		competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
		competitorsrate[index++]=competitors.getHead().getCompetitor();
		competitors.removehead();
		while (!competitors.isEmpty()) {
			ratedcompetitors++;
			if (lastscore>((Amrap)(competitors.getHead().getCompetitor())).getNumofreps()) {
				lastscore= ((Amrap)(competitors.getHead().getCompetitor())).getNumofreps();
				lastscoretiebreaker= ((NodeAmrap_reps) (competitors.getHead())).getSecondreps();
				competitors.getHead().getCompetitor().setEventrate(++point);
				competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
					point=ratedcompetitors;
				competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
				competitorsrate[index++]=competitors.getHead().getCompetitor();
				competitors.removehead();
			}
			else {
				if (lastscoretiebreaker==((NodeAmrap_reps) (competitors.getHead())).getSecondreps()) {
					competitors.getHead().getCompetitor().setEventrate(point);
					competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
					competitorsrate[index++]=competitors.getHead().getCompetitor();
					competitors.removehead();
				}
				else {
					lastscore= ((Amrap)(competitors.getHead().getCompetitor())).getNumofreps();
					lastscoretiebreaker= ((NodeAmrap_reps) (competitors.getHead())).getSecondreps();
					competitors.getHead().getCompetitor().setEventrate(++point);
					competitors.getHead().getCompetitor().setEventrate(ratedcompetitors);
						point=ratedcompetitors;
					competitors.getHead().getCompetitor().setTotalrate(competitors.getHead().getCompetitor().getEventrate()+competitors.getHead().getCompetitor().getTotalrate());
					competitorsrate[index++]=competitors.getHead().getCompetitor();
					competitors.removehead();
				}
				
			}
		}
		return competitorsrate;
	}

}
