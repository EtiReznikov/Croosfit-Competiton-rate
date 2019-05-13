package competitors;
/**
 * class that representing For Time event
 * @author EtiReznikov
 */
import java.util.Date;

public class Fortime extends Competitor {

	long time;
	int reps;
	public Fortime(Competitor competitor) {
		super(competitor);
	}


	/*public Fortime( int id, int totalrate, int rownum) {
		super(id,totalrate,rownum);
		time=0;
	}*/
	public Fortime( int id,int totalrate, String timeasdate, int reps, int rownum) {
		super(id,totalrate,rownum);
		this.time=tomilisecond(timeasdate);
		this.reps=reps;
	}
	public long getTime() {
		return time;
	}
	
	public int getReps() {
		return reps;
	}


	public static long tomilisecond(String time) {
		//return time.getTime();
		int minutes= Integer.parseInt(time.substring(0, 2));
		int seconds= Integer.parseInt(time.substring(3, 5));
		return minutes*60000+seconds*1000;
		
	}

}
