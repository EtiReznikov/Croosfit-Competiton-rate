package competitors;
/**
 * class that representing AMRAP event- as many reps as possible
 * @author EtiReznikov
 */
public class Amrap extends Competitor {
	private int numofreps;
	public Amrap(Competitor competitor) {
		super(competitor);
	}
	public Amrap( int id,int totalrate, int numofreps, int rownum) {
		super(id,totalrate,rownum);
		this.numofreps=numofreps;
	}
	public int getNumofreps() {
		return numofreps;
	}
	

}
