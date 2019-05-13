package competitors;
/**
 * class that representing Weight event
 * @author EtiReznikov
 */
public class Weight extends Competitor {
	private double wieght;

	public Weight(Competitor competitor) {
		super(competitor);
	}

	public Weight( int id, int totalrate, double wieght, int rownum) {
		super(id,totalrate,rownum);
		this.wieght=wieght;
	}
	public double getWieght() {
		return wieght;
	}

}
