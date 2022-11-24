
public class Server extends Staff {
	
	private int targetTipPct;

	public Server(String name, int targetTipPct){

		//server is not a cook
		super(name, false);
		this.targetTipPct = targetTipPct;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}
}

